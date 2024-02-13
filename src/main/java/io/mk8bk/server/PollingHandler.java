package io.mk8bk.server;

import com.sun.net.httpserver.*;
import io.mk8bk.controller.ChessController;
import io.mk8bk.engine.ChessEngine;

import java.io.IOException;

public class PollingHandler implements HttpHandler {


    private ChessController controller;

    @Override
    public void handle(HttpExchange exchange) throws IOException {
        String username = (String) exchange.getAttribute("username");
    }

    private void handleUserRequest(HttpExchange exchange) {
        
    }

    private void serveRoleUI(HttpExchange exchange) {
        
    }

    public void registerController(ChessController controller) {
        if(this.controller == null){
            this.controller = controller;
        }else{
            throw new RuntimeException("Controller already registered.");
        }
    }
}
