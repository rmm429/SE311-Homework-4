package se311.state;

import se311.composite.AtomExpr;
import se311.mvc.Model;

// Concrete State in a State Pattern
public class GetAddSub implements State {

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
        } else if (button.matches("\\+|-")) { // plus or minus pressed
            next = new WaitAddSub();
        } else if (button.matches("÷|×")) { // multiply or divide pressed
            next = new WaitMulDiv();
        } else if (button.matches("=")) { // equals pressed
            next = new Calculate();
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

        // If the root has no right child, make the right child an atomic Expression containing the current symbol
        if(Model.expressionTree.getRightChild() == null) {
            Model.expressionTree.addRightChild(new AtomExpr(symbol));;
        } else { // there is a right child
            // Append the current symbol onto the existing atomic Expression
            String currentNumber = Model.expressionTree.getRightChild().getSymbol();
            Model.expressionTree.getRightChild().setSymbol(currentNumber + symbol);
        }
    }
    
}
