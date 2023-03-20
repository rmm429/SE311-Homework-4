package se311.state;

import se311.composite.AtomExpr;
import se311.mvc.Model;

// Concrete State in a State Pattern
public class CalMulDiv implements State {

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
            Model.expressionTree.addRightChild(new AtomExpr(symbol));
        } else { // there is a right child

            // If the right child is an atomic Expression, append the current symbol onto it
            if(Model.expressionTree.getRightChild() instanceof AtomExpr) {
                String currentNumber = Model.expressionTree.getRightChild().getSymbol();
                Model.expressionTree.getRightChild().setSymbol(currentNumber + symbol);
            } else { // the right child is not an atomic Expression

                // If the right child is not an atomic Expression and it has no right child,
                // make that Expression's right child an atomic Expression containing the current symbol
                if(Model.expressionTree.getRightChild().getRightChild() == null) {
                    Model.expressionTree.getRightChild().addRightChild(new AtomExpr(symbol));
                } else { // the right child is not an atomic Expression and has an existing right child
                    // Append the current symbol to that Expression's right child
                    String currentNumber = Model.expressionTree.getRightChild().getRightChild().getSymbol();
                    Model.expressionTree.getRightChild().getRightChild().setSymbol(currentNumber + symbol);
                }

            }

        }

    }
    
}
