package se311;

import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.net.SocketException;
import java.net.SocketTimeoutException;

public class RequestHandler extends Thread {

    private Socket clientSocket;

    public RequestHandler(Socket _clientSocket) {
        clientSocket = _clientSocket;
    }

    /**
     * Executes threaded actions upon a call by start()
     */
    public void run() {

        try {

            // Create an InputStream to read the keyword from the Client
            ObjectInputStream in = new ObjectInputStream(clientSocket.getInputStream());

            // Keep reading and printing equations from Client
            while(true) {
                String equation = (String) in.readObject();
                Driver.numEquations++;
                System.out.println("(Equation " + Driver.numEquations + ") | " + equation);
            }

        } catch (SocketException | SocketTimeoutException se) { // Client closed connection
            try { clientSocket.close(); } catch (IOException ioe) { ioe.printStackTrace(); } // close Client socket on Server side
        } catch (IOException | ClassNotFoundException ignore) {}

    }

}
