package se311;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Driver {

    // Allows to keep track of all equations across every Client
    public static int numEquations;

    public static void main(String[] args) throws IOException {

        final int serverPort = 2023;

        // Bind this Server to a port (local host)
        ServerSocket server = new ServerSocket(serverPort);

        // Request handler that will handle multiple Clients
        while(true) {
            Socket client = server.accept();
            RequestHandler requestHandler = new RequestHandler(client);
            requestHandler.start();
        }

    }

}
