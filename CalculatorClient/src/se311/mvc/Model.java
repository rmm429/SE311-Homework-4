package se311.mvc;

import se311.dialog.ErrorDialog;
import se311.state.*;
import se311.state.Error;

public class Model {

    private View calc;
    private State current, previous;
    private String operand1, operator, operand2;

    public Model(View _calc) {
        calc = _calc;
        current = new Start();
    }

    public void updateModel(String command) {

        updateView(command);

        previous = current; // Stored in case of discard within error state
        // Context in the State Pattern
        current = current.handle(command);

        if (current instanceof Error) {
            handleError();
        } else if (current instanceof Calculate) {
            resetCalculation();
        }

    }

    private void handleError() {

        ErrorDialog error = new ErrorDialog();
        int selection = error.getSelection();

        if(selection == 0) {
            // Reset
            System.out.println("RESET");
            resetCalculation();
        } else if (selection == 1){
            // Discard
            System.out.println("DISCARD");
            discardLastCommand();
        } else { // User closes the dialog box without selecting an option
            handleError(); // Ensures that user selects an option
        }

    }

    private void resetCalculation() {
        operand1 = operator = operand2 = null;
        current = new Start();
    }

    private void discardLastCommand() {
        operand2 = null;
        current = previous;
    }

    private void updateView(String display) {
        calc.updateResults(display);
    }

}
