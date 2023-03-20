package se311.mvc;

import se311.composite.Expression;
import se311.state.*;
import se311.state.Error;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;

// This Model takes the Context role in a State Pattern
public class Model {

    // Professor recommended I use static variables (accessed within the concrete States)
    public static State previous;
    public static Expression expressionTree;

    private View calc;
    private State current;
    private String previousDisplay;

    public Model(View _calc) {
        calc = _calc;
        current = new Start();
        previousDisplay = "";
    }


    /**
     * Advance the State Machine and update the Expression tree
     *
     * @param	symbol	    the user-inputted button
     */
    public void updateModel(String symbol) {

        // Stored in case of discard within Error state
        previous = current;
        // Context in the State Pattern
        current = current.getNextState(symbol);

        // User Scenario US9
        if(previous instanceof Start && current instanceof Start) {
            updateDisplay(" ");
        }

        // Handle Error state with user choice
        if(current instanceof Error) {

            // Decides next state based on user input
            current = current.getNextState(symbol);
            if (current instanceof Start) { // Ensures tree will be cleared if user selected RESET
                current.updateTree(symbol);
                updateDisplay(" ");
            }

        } else { // Non-Error state

            // The core (Non-Error state) operation that handles building expression tree
            current.updateTree(symbol);

            if (current instanceof Calculate) {
                handleCalculationResults(symbol);
                // Ensure that the machine will go to Start state after calculation
                current = current.getNextState(symbol);

            }

        }

        // Display the user-inputted button on the calculator
        updateDisplay(symbol);

    }

    /**
     * Call the helper methods of the Calculate State to perform a calculation
     *
     * @param   symbol      The symbol of the button last pressed
     */
    private void handleCalculationResults(String symbol) {

        // Clear what was previously displayed from memory
        previousDisplay = "";

        // Returned from the Visitors
        double result = ((Calculate) current).getResult();
        // View panel will display the result with this number of decimal places
        int places = 14;

        try {

            // Ensure that a large decimal value will display no more than the designated number of decimal places
            BigDecimal resultRounded = new BigDecimal(result);
            resultRounded = resultRounded.setScale(places, RoundingMode.HALF_UP).stripTrailingZeros();
            updateDisplay(resultRounded.toPlainString());

            // Send the equation to the Server upon successful calculation
            String equation = ((Calculate) current).getEquation();
            equation += " " + symbol + " " + resultRounded.toPlainString();
            try {
                Controller.connection.send(equation);
            } catch (IOException ignored) {}

        } catch (NumberFormatException nfe) { // User attempted to divide by 0
            updateDisplay("Cannot divide by 0");
        }


    }

    /**
     * Display content in the Calculator view panel
     *
     * @param	display	    the value to be displayed
     */
    private void updateDisplay(String display) {

        // Will display the number of a button, calculation results, or error message
        if (display.matches("[0-9]+\\.*[0-9]*") || display.length() > 1) {

            // If what was previously displayed was a number, append the current
            // number of a button to the previous number in the display panel
            if (previousDisplay.matches("[0-9]+")) { // I
                display = previousDisplay + display;
            }
            calc.updateDisplay(display);

        } else if (display.equals("C") | display.equals(" ")) { // clear display
            calc.updateDisplay(" ");
        }

        // Keep track of what was displayed
        previousDisplay = display;

    }

}