package se311.state;

import se311.mvc.Model;

// Concrete State in a State Pattern
public class Start implements State {

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
        } else { // any other button pressed
            // User Scenario US4
            next = new Start();
        }

        log += " -> " + next.getClass().getSimpleName();

        System.out.println("\n" + log);
        return next;

    }

    /**
     * Update the expression tree based on what button was pressed
     *
     * @param	symbol	    the value of the button pressed
     */
    @Override
    public void updateTree(String symbol) {
        // Clear the Expression tree
        Model.expressionTree = null;
    }

}
