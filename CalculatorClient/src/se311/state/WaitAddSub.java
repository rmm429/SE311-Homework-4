package se311.state;

import se311.composite.AddSubExpr;
import se311.mvc.Model;

// Concrete State in a State Pattern
public class WaitAddSub implements State {

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
            next = new GetAddSub();
        } else if (button.matches("÷|×|-|\\+|=")) { // operator button pressed
            // User Scenario US6
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

        // Create an addition-subtraction Expression whose left child is the root of the Expression tree
        AddSubExpr leftChildAddSub = new AddSubExpr();
        leftChildAddSub.setSymbol(symbol); // plus or minus
        leftChildAddSub.addLeftChild(Model.expressionTree);

        // Make the addition-subtraction Expression the new root of the Expression tree
        Model.expressionTree = leftChildAddSub;

    }
    
}
