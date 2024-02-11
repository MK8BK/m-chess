package io.mk8bk.server;

import com.sun.net.httpserver.Headers;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URLConnection;
import java.nio.file.Files;
import java.util.Objects;

public class StaticHandler implements HttpHandler {

    @Override
    public void handle(HttpExchange exchange) throws IOException {
        if(!Objects.equals(exchange.getRequestMethod(), "GET")){
            exchange.sendResponseHeaders(HttpURLConnection.HTTP_BAD_REQUEST, 0);
        }

        // get resource path
        URI resourceURI = exchange.getRequestURI();
        String resourcePath = resourceURI.getPath().substring(7); // "/static/[rest]"

        System.out.println("  Handling request for "+resourceURI+".");

        // load resource
        byte[] encodedResource = loadResource(resourcePath);

        // compose response
        Headers headers = exchange.getResponseHeaders();
        String mimetype = URLConnection.guessContentTypeFromName(resourcePath);
        headers.add("content-type",mimetype); // +";charset=UTF-8"

        // send headers
        long responseLength = encodedResource.length;
        exchange.sendResponseHeaders(HttpURLConnection.HTTP_OK, responseLength);

        OutputStream bodyStream = exchange.getResponseBody();
        bodyStream.write(encodedResource);
        bodyStream.flush();
        bodyStream.close();
    }

    private byte[] loadResource(String resourceName) throws IOException {
        File file = new File("src/main/resources"+resourceName);
        return Files.readAllBytes(file.toPath());
    }
}
