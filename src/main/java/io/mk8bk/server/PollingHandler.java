package io.mk8bk.server;

import com.sun.net.httpserver.*;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Base64;

public class PollingHandler implements HttpHandler {

    @Override
    public void handle(HttpExchange exchange) throws IOException {
        String username = (String) exchange.getAttribute("username");

    }

    /**
     * Adapted from openjdk implementation of BasicAuthenticator.
     * @param headers
     * @return
     */
    public String getUserName(Headers headers){

        // will be thrown during auth if null
        String auth = headers.getFirst ("Authorization");

        int sp = auth.indexOf (' ');
        byte[] b = Base64.getDecoder().decode(auth.substring(sp+1));
        String userpass = new String (b, Charset.defaultCharset());
        int colon = userpass.indexOf (':');

        return userpass.substring (0, colon);
    }
}
