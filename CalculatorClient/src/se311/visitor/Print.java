package se311.visitor;

import se311.composite.*;

// Concrete Visitor in a Visitor Pattern
public class Print implements Visitor {

    private String equation;

    public Print() {
        clear();
    }

    /**
     * Build an equation string from the Expression tree
     *
     * @param	expr	    the Expression tree
     * @return				the result of the equation building
     */
    public String getEquation(Expression expr) {
        expr.accept(this);
        return equation;
    }

    /**
     * Build from an addition-subtraction Expression
     *
     * @param	in  	    the addition-subtraction Expression
     */
    @Override
    public void visitAddSubExpr(AddSubExpr in) {
        // Visit each child to evaluate child expression until atomic value reached and store results
        in.getLeftChild().accept(this);
        equation += in.getSymbol(); // Operator (plus or minus)
        in.getRightChild().accept(this);
    }

    /**
     * Build from a multiplication-division Expression
     *
     * @param	in  	    the multiplication-division Expression
     */
    @Override
    public void visitMulDivExpr(MulDivExpr in) {
        // Visit each child to evaluate child expression until atomic value reached and store results
        in.getLeftChild().accept(this);
        equation += in.getSymbol(); // Operator (multiply or divide)
        in.getRightChild().accept(this);
    }

    /**
     * Build from a multiplication-division operation
     *
     * @param	in  	    the multiplication-division operation
     */
    @Override
    public void visitMulDivOp(MulDivOp in) {
        // Visit each child to evaluate child expression until atomic value reached and store results
        in.getLeftChild().accept(this);
        equation += in.getSymbol(); // Operator (multiply or divide)
        in.getRightChild().accept(this);
    }

    /**
     * Get the value from an atomic Expression
     *
     * @param	in  	    the atomic Expression
     */
    @Override
    public void visitAtomExpr(AtomExpr in) {
        equation += in.getSymbol();
    }

    /**
     * Clear the current equation
     *
     */
    @Override
    public void clear() {
        equation = "";
    }

}
