package se311.mvc;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// Create a class that implements ActionListener
// This listener will be attached to the calculator view
// has actionPerformed(ActionEvent e)

// This controller takes the observer role in an observer pattern
public class Controller implements ActionListener {

//    private View calc;
//    private State current;

    private Model model;

//    public Controller(View _calc) {
//        calc = _calc;
//        current = new Start();
//    }

    public Controller(Model _model) {
        model = _model;
    }

    // State logic is better in the Model, not controller


    @Override
    public void actionPerformed(ActionEvent e) {

        // call Model to do State Transition

        String command = e.getActionCommand();
        model.updateModel(command);



//        calc.updateResults(command);
//
//        // Context in the State Pattern
//        current = current.handle(command);
//
//        if (current instanceof Error) {
//            ErrorDialog ed = new ErrorDialog();
//            System.out.println(ed.getSelection());
//        }

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
