package se311.state;

import se311.composite.MulDivExpr;
import se311.composite.MulDivOp;
import se311.mvc.Model;

// Concrete State in a State Pattern
public class WaitMulDiv implements State {

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
            next = new CalMulDiv();
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

        // Create a multiplication-division Expression
        MulDivExpr leftChildMulDiv = new MulDivOp();
        leftChildMulDiv.setSymbol(symbol);

        // If the root of the Expression tree has no children,
        // make the root the left child of the multiplication-division Expression
        // and set this Expression as the new root
        if(Model.expressionTree.getLeftChild() == null && Model.expressionTree.getRightChild() == null) {
            leftChildMulDiv.addLeftChild(Model.expressionTree);
            Model.expressionTree = leftChildMulDiv;
        } else { // there are children
            // Set the left child of the multiplication-division Expression to the right child of the root
            leftChildMulDiv.addLeftChild(Model.expressionTree.getRightChild());
            // Set the right child of the root to the multiplication-division Expression
            Model.expressionTree.addRightChild(leftChildMulDiv);
        }

    }
    
}
