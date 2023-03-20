package se311.mvc;

import se311.client.Connection;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

// This Controller takes the Observer role in an Observer Pattern
public class Controller implements ActionListener {

    public static Connection connection;
    private Model model;


    public Controller(Model _model) throws IOException {
        model = _model;
        connection = new Connection();
        connection.connect();
        System.err.println("State Machine log:");
    }

    /**
     * Triggered action whenever a button is pressed in the Calculator view
     *
     * @param	    e       the button that triggered this action
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        // Label of the button pressed
        String symbol = e.getActionCommand();
        // Call Model to do State Transition and build Expression tree
        model.updateModel(symbol);
    }

}
