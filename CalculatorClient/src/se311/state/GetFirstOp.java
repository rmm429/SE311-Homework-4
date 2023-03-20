package se311.state;

import se311.composite.AtomExpr;
import se311.mvc.Model;

// Concrete State in a State Pattern
public class GetFirstOp implements State {

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
        String log = this.getClass().getSimpleName() + ": " + button;

        if (button.matches("[0-9]")) { // number button pressed
            next = new GetFirstOp();
        } else if (button.matches("\\+|-")) { // plus or minus pressed
            next = new WaitAddSub();
        } else if (button.matches("÷|×")) { // multiply or divide pressed
            next = new WaitMulDiv();
        } else if (button.matches("=")) { // equals pressed
            // User Scenario US7
            next = new Error();
        } else { // clear pressed
            next = new Start();
        }

        log += " -> " + next.getClass().getSimpleName();

        System.out.println(log);
        return next;

    }

    /**
     * Update the expression tree based on what button was pressed
     *
     * @param	symbol	    the value of the button pressed
     */
    @Override
    public void updateTree(String symbol) {

        // If there is nothing in the expression tree, make the root an atomic Expression containing the current symbol
        if(Model.expressionTree == null) {
            Model.expressionTree = new AtomExpr(symbol);
        } else { // the Expression tree already contains an atomic Expression as the root
            // Append the current symbol onto the existing atomic Expression
            String currentNumber = Model.expressionTree.getSymbol();
            Model.expressionTree.setSymbol(currentNumber + symbol);
        }

    }

}
