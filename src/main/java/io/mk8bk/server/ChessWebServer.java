package io.mk8bk.server;

import com.sun.net.httpserver.HttpContext;
import com.sun.net.httpserver.HttpServer;
import io.mk8bk.controller.ChessController;

import java.io.IOException;
import java.net.InetSocketAddress;
public class ChessWebServer {
    private static ChessWebServer chessWebServer = ChessWebServer.getInstance();
    private ChessController controller;

    public static ChessWebServer getInstance() {
        if(ChessWebServer.chessWebServer == null)
            ChessWebServer.chessWebServer = new ChessWebServer();
        return ChessWebServer.chessWebServer;
    }
    private final HttpServer httpServer;
    private final StaticHandler staticHandler;
    private final PollingHandler pollingHandler;
    private ChessWebServer(){
        // create server
        try {
            httpServer = HttpServer.create();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // bind to port
        int portLimit = 20000;
        for(int i=8000; i<=portLimit; i++){
            try {
                // backlog is 1, serve a single client
                httpServer.bind(new InetSocketAddress(i), 1);
                break;
            } catch (IOException e) {
                if(i==portLimit)
                    throw new RuntimeException(e);
            }
        }

        staticHandler = new StaticHandler();
        pollingHandler = new PollingHandler();

        HttpContext staticContext = httpServer.createContext("/static/", staticHandler);
        HttpContext pollContext = httpServer.createContext("/poll/", pollingHandler);
        ChessAuthenticator staticChessAuthenticator = new ChessAuthenticator("enterprise_fucker/");
        ChessAuthenticator pollingChessAuthenticator = new ChessAuthenticator("enterprise_fucker/");
        staticContext.setAuthenticator(staticChessAuthenticator);
        pollContext.setAuthenticator(pollingChessAuthenticator);
    }

    public void start(){
        int port = httpServer.getAddress().getPort();
        String link = "http://localhost:"+port+"/static/index.html";
        System.out.println("Chess server starting ...");
        httpServer.start();
        System.out.println("Chess server started successfully.");
        System.out.println("Visit "+link+" to start playing.");
    }

    public void registerController(ChessController chessController) {
        if(controller == null){
            this.controller = chessController;
            this.pollingHandler.registerController(controller);
        }

        else
            throw new RuntimeException("Controller already set");
    }
}
