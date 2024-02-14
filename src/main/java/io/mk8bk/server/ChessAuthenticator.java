package io.mk8bk.server;


import com.sun.net.httpserver.BasicAuthenticator;
import com.sun.net.httpserver.HttpExchange;
import io.mk8bk.controller.ChessController;

import java.util.Objects;

import static java.lang.Math.max;

public class ChessAuthenticator extends BasicAuthenticator {
    public static String getPlayer1Username() {
        return player1Username;
    }

    public static String getPlayer2Username() {
        return player2Username;
    }

    private static String player1Username = null;
    private static String player2Username = null;
    private static String player1Password = null;
    private static String player2Password = null;
    private static final String usernameCookie = "chess-player-name";

    public ChessAuthenticator(String realm) {
        super(realm);
    }

    @Override
    public Result authenticate(HttpExchange httpExchange){
        Result r = super.authenticate(httpExchange);
        if(r instanceof Success s) {
            String userName = s.getPrincipal().getName();
            httpExchange.setAttribute("username", userName);
        }
        return r;
    }

    @Override
    public boolean checkCredentials(String username, String password) {
        // cant change super method authenticate, so handle nulls here
        if (username == null || password == null)
            return false;

        // set if first player connection
        if (null == player1Password && null == player1Username) {
            player1Password = password;
            player1Username = username;
            return true;
        }
        // first player will probably send multiple requests
        if (null == player2Password && null == player2Username && !Objects.equals(player1Username, username)) {
            player2Password = password;
            player2Username = username;
            return true;
        }

        // check if player is one of the two
        return Objects.equals(player1Username, username) && Objects.equals(player1Password, password)
                || Objects.equals(player2Username, username) && Objects.equals(player2Password, password);

    }
}
