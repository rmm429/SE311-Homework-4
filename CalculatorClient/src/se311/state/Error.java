package se311.state;

import se311.dialog.ErrorDialog;
import se311.mvc.Model;

// Concrete State in a State Pattern
public class Error implements State {

    private State next;

    /**
     * Get the next State based on what the current button pressed is
     *
     * @param	button	    the button pressed
     * @return				the next State
     */
    @Override
    public State getNextState(String button) {

        // Logs the State Machine transitions in the console
        String log = this.getClass().getSimpleName();

        // Give the user an option to choose what to do with the Error state
        handleError();

        log += " -> " + next.getClass().getSimpleName();

        System.out.println(log);
        return next;

    }

    /**
     * Present the user with a Dialog box to choose how to handle an Error state
     * Executed in an isolated method as to avoid recursion with a return value (if it was done in getNextState())
     *
     */
    private void handleError() {

        // Error dialog box and user selection
        ErrorDialog error = new ErrorDialog();
        int selection = error.getSelection();

        // Transition the State Machine based on user response
        if(selection == 0) { // Reset
            System.out.println("RESET");
            // Go to start state, clear results
            next = new Start();
        } else if (selection == 1) { // Discard
            System.out.println("DISCARD");
            // Go back to the previous state
            next = Model.previous;
        } else { // User closed the dialog box without selecting an option
            handleError(); // Ensures that user selects an option
        }

    }

    // Will never be called since an Error state is immediately transitioned via handleError()
    @Override
    public void updateTree(String symbol) {}
    
}
