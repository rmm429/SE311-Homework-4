package se311;

import se311.controller.state.*;
import se311.controller.state.Error;
import se311.view.CalculatorView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// Create a class that implements ActionListener
// This listener will be attached to the calculator view
// has actionPerformed(ActionEvent e)

public class CalculatorHandler implements ActionListener {

    private CalculatorView calc;
    private State current;

    public void init() {

        calc = new CalculatorView();
        current = new Start();
        calc.attachListener(this);

    }


    @Override
    public void actionPerformed(ActionEvent e) {

        String command = e.getActionCommand();
        calc.updateResults(command);

        // Context in the State Pattern
        current = current.handle(command);

//        // Don't want a button press to be ingested inside of Calculate or Error states
//        if (current instanceof Calculate || current instanceof Error) {
//            current = new Start();
//        }

    }

    // changeTree()
    // one instance of the tree in each context

    // method in each State called changeTree()
    // States will move forward (next) and change tree (composite)
    // State will determine if tree is atomic or has children

}
