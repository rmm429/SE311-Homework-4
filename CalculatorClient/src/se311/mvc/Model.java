package se311.mvc;

import se311.composite.AddSubExpr;
import se311.composite.AtomExpr;
import se311.composite.Expression;
import se311.dialog.ErrorDialog;
import se311.state.*;
import se311.state.Error;
import se311.visitor.Compute;

import java.util.ArrayList;

public class Model {

    private View calc;
    private State current, previous;
    // private Expression operand1, operator, operand2;
    private String symbol;
    private ArrayList<String> symbolList;

    public Model(View _calc) {
        calc = _calc;
        current = new Start();
        symbol = "";
        symbolList = new ArrayList<>();
    }

    public void updateModel(String _symbol) {

        symbol = _symbol;

        updateDisplay(symbol);

//        Expression add = new AddSubExpr(new AtomExpr(3), new AtomExpr(4));
//        Compute compute = new Compute();
//        double result = compute.doComputation(add);
//        System.out.println(result);

        // 1st: each state has a handle method
        // update the tree model

        // 2nd: record input as string
        // once equal is clicked, build tree
        // calculate state handles calculation
        // addsub finds plus, uses left and right of that for calculation
        // e.g. addsub sees 2 as left and 3*5 as right



        // MulDivExpr is abstract
        // AtomExpr is a number (e.g. 3)
        // MulDivOp is a binary multiply/divide (e.g. 4*5)
        // so MulDivExpr could be 3*4*5, where 3 is AtomExpr and 4*5 is MulDivOp

        previous = current; // Stored in case of discard within error state
        // Context in the State Pattern
        current = current.handle(symbol);

        // Have blank expression, pass to calculate to build tree, reference built tree here via visitors to do operations

        determineAction();



    }

    private void determineAction() {

        if (symbol.equals("C")) { // Clear entire calculation progress
            resetCalculation();
        } else if (current instanceof Error) { // Handle Error state
            handleError();
        } else if (current instanceof Calculate) { // Calculate equation and reset
            handleCalculation();
            resetCalculation();
        } else if (!(current instanceof Start && previous instanceof Start)) { // = pressed at Start, don't record symbol

            int lastIndex = symbolList.size() - 1;

            // If two numbers are pressed sequentially, combine them into one number in the list
            if(!symbolList.isEmpty() && symbol.matches("[0-9]") && symbolList.get(lastIndex).matches("[0-9]")) {
                String prevNumber = symbolList.get(lastIndex);
                prevNumber += symbol;
                symbolList.set(lastIndex, prevNumber);
            } else { // Add current symbol to the list
                symbolList.add(symbol);
            }

        }

    }

    private void handleCalculation() {

        Expression expressionTree = ((Calculate) current).buildTree(symbolList);

    }

    private void handleError() {

        // Error dialog box
        ErrorDialog error = new ErrorDialog();
        int selection = error.getSelection();

        if(selection == 0) { // Reset
            System.out.println("RESET\n");
            resetCalculation();
        } else if (selection == 1) { // Discard
            System.out.println("DISCARD");
            discardLastCommand();
        } else { // User closes the dialog box without selecting an option
            handleError(); // Ensures that user selects an option
        }

    }

    private void resetCalculation() {
        // operand1 = operator = operand2 = null;
        current = new Start();
        symbolList.clear();
    }

    private void discardLastCommand() {
        // operand2 = null;
        current = previous;
    }

    private void updateDisplay(String display) {
        calc.updateResults(display);
    }

}
