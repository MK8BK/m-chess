package io.mk8bk.server;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.net.httpserver.*;
import io.mk8bk.commons.ChessColor;
import io.mk8bk.controller.ChessController;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.util.Objects;

public class PollingHandler implements HttpHandler {
    private final ObjectMapper objectMapper;


    private ChessController controller;

    public PollingHandler() {
        objectMapper = new ObjectMapper();
    }

    @Override
    public void handle(HttpExchange exchange) throws IOException {
        String username = (String) exchange.getAttribute("username");
        String contentType = exchange.getRequestHeaders().getFirst("content-type");

        // only accept json
        if(!Objects.equals(contentType, "application/json")){
            exchange.sendResponseHeaders(HttpURLConnection.HTTP_BAD_REQUEST, 0);
        }

        JsonNode requestJson = objectMapper.readTree(exchange.getRequestBody());

        // register color choice
        if(requestJson.has("color-choice")){
            JsonNode s = requestJson.get("color-choice");
            if(s.isTextual()){
                String chosenColor = s.toString();
                ChessColor chessColor;
                if(Objects.equals(chosenColor, "black")){
                    chessColor = ChessColor.BLACK;
                }else if(Objects.equals(chosenColor, "white")){
                    chessColor = ChessColor.WHITE;
                }else{
                    byte[] response = "invalid color; only allowed are \"black\" and \"white\"".getBytes();
                    exchange.sendResponseHeaders(HttpURLConnection.HTTP_BAD_REQUEST, response.length);
                    exchange.getResponseBody().write(response);
                    return;
                }
                controller.setUserColor(username, chessColor);
                return;
            }
        }

        // offer color choice
        if(!controller.playerHasColor(username)){
            boolean hasChoice = controller.canChooseColor(username);
            if(hasChoice){
                byte[] response = "No color set. Choose black or white. in ".getBytes();
                exchange.sendResponseHeaders(HttpURLConnection.HTTP_BAD_REQUEST, response.length);
                exchange.getResponseBody().write(response);
                return;
            }
        }

    }


    private void handleUserPoll(HttpExchange exchange) {
        try {
            JsonNode node = objectMapper.readTree(exchange.getRequestBody());
            System.out.println(node.get("action-type"));
            exchange.sendResponseHeaders(200, 0);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

    private void sendChessRoleUI(HttpExchange exchange) {
    }


    public void registerController(ChessController controller) {
        if(this.controller == null){
            this.controller = controller;
        }else{
            throw new RuntimeException("Controller already registered.");
        }
    }
}
