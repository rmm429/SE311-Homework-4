package se311.state;

import se311.mvc.Model;
import se311.visitor.*;

// Concrete State in a State Pattern
public class Calculate implements State {

    private State next;
    private double result;
    private String equation;

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

        next = new Start();
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
        // Perform Visitor operations and clear the Expression tree
        callVisitors();
        Model.expressionTree = null;
    }

    /**
     * Call all created Visitors on the Expression tree
     *
     */
    private void callVisitors() {

        // Print Visitor
        Print print = new Print();
        equation = print.getEquation(Model.expressionTree);
        print.clear();

        // Compute visitor
        Compute compute = new Compute();
        result = compute.performCompute(Model.expressionTree);
        compute.clear();

    }

    /**
     * Return the results from the Compute Visitor computation
     *
     * @return				the result of the calculation
     */
    public double getResult() {
        return result;
    }

    /**
     * Return the equation built by the Print Visitor
     *
     * @return				the next State
     */
    public String getEquation() {
        return equation;
    }
    
}
