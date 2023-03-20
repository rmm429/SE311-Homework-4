package se311.visitor;

import se311.composite.*;

// Concrete Visitor in a Visitor Pattern
public class Compute implements Visitor {

    private double result;

    public Compute() {
        clear();
    }

    /**
     * Perform computation of the Expression tree
     *
     * @param	expr	    the Expression tree
     * @return				the result of the calculation
     */
    public double performCompute(Expression expr) {
        expr.accept(this);
        return result;
    }

    /**
     * Compute an addition-subtraction Expression
     *
     * @param	in  	    the addition-subtraction Expression
     */
    @Override
    public void visitAddSubExpr(AddSubExpr in) {

        // Visit each child to evaluate child expression until atomic value reached and store results
        in.getLeftChild().accept(this);
        double left = result;
        in.getRightChild().accept(this);
        double right = result;

        // Operator (plus or minus)
        String symbol = in.getSymbol();
        // Perform addition or subtraction
        if(symbol.equals("+")) {
            result = left + right;
        } else {
            result = left - right;
        }

    }

    /**
     * Compute a multiplication-division Expression
     *
     * @param	in  	    the multiplication-division expression
     */
    @Override
    public void visitMulDivExpr(MulDivExpr in) {

        // Visit each child to evaluate child expression until atomic value reached and store results
        in.getLeftChild().accept(this);
        double left = result;
        in.getRightChild().accept(this);
        double right = result;

        // Operator (multiply or divide)
        String symbol = in.getSymbol();
        // Perform multiplication or division
        if(symbol.equals("×")) {
            result = left * right;
        } else {
            result = left / right;
        }
    }

    /**
     * Compute a multiplication-division operation
     *
     * @param	in  	    the multiplication-division operation
     */
    @Override
    public void visitMulDivOp(MulDivOp in) {

        // Visit each child to evaluate child expression until atomic value reached and store results
        in.getLeftChild().accept(this);
        double left = result;
        in.getRightChild().accept(this);
        double right = result;

        // Operator (multiply or divide)
        String symbol = in.getSymbol();
        // Perform multiplication or division
        if(symbol.equals("×")) {
            result = left * right;
        } else {
            result = left / right;
        }

    }

    /**
     * Get the value from an atomic Expression
     *
     * @param	in  	    the atomic Expression
     */
    @Override
    public void visitAtomExpr(AtomExpr in) {
        result = Double.parseDouble(in.getSymbol());
    }

    /**
     * Clear the current result
     *
     */
    @Override
    public void clear() {
        result = 0.0;
    }

}
