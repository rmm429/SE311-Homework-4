package se311.client;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.SocketException;

public class Connection {

    Socket socket;
    ObjectOutputStream out;

    public Connection() {
        socket = null;
    }

    public void connect() throws IOException {

        final int serverPort = 2023;
        // Get the address information for the local host
        InetAddress localHost = InetAddress.getLocalHost();

        try {

            // Create a socket to connect to the server
            System.out.println("Connecting to Server, please wait before entering equation...");
            socket = new Socket(localHost.getHostAddress(), serverPort);
            System.out.println("Connected to Server!\n");

            out = new ObjectOutputStream(socket.getOutputStream());

        } catch (SocketException se) { // cannot reach Server
            System.err.println("ERROR: Server cannot be reached!");
            System.err.println("Check to see if the Server is online\n");
            if (socket != null) { socket.close(); } // Close connection to Server
        }

    }

    public void send(String equation) throws IOException {
        try {
            out.writeObject(equation);
        } catch (NullPointerException ignored) {}

    }

    public void close() throws IOException {
        out.close();
        socket.close();
    }

}
