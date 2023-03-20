package se311.composite;

import se311.visitor.Visitor;

// Composite in a Composite pattern
public abstract class MulDivExpr implements Expression {

    private MulDivExpr leftChild, rightChild;
    private String symbol;

    public MulDivExpr() {
        leftChild = rightChild = null;
    }

    public MulDivExpr(MulDivExpr lc, MulDivExpr rc) {
        leftChild = lc;
        rightChild = rc;
    }

    /**
     * Let a Visitor perform an operation on a specific multiplication-division Expresion
     *
     * @param	visitor	    a Visitor that handles a certain type of operation
     */
    @Override
    public void accept(Visitor visitor) {
        visitor.visitMulDivExpr(this);
    }

    /**
     * Add an expression as the left child of a specific multiplication-division Expresion
     *
     * @param	lc  	    the Expression that will be added as the left child
     */
    @Override
    public void addLeftChild(Expression lc) {
        // Cast to MulDivExpr since a multiplication-division Expression
        // can only contain other multiplication-division Expressions
        leftChild = (MulDivExpr) lc;
    }

    /**
     * Add an expression as the right child of a specific multiplication-division Expresion
     *
     * @param	rc  	    the Expression that will be added as the right child
     */
    @Override
    public void addRightChild(Expression rc) {
        // Cast to MulDivExpr since a multiplication-division Expression
        // can only contain other multiplication-division Expressions
        rightChild = (MulDivExpr) rc;
    }

    /**
     * Remove the left child of a specific multiplication-division Expresion
     *
     */
    @Override
    public void removeLeftChild() {
        leftChild = null;
    }

    /**
     * Remove the right child of a specific multiplication-division Expresion
     *
     */
    @Override
    public void removeRightChild() {
        rightChild = null;
    }

    /**
     * Get the left child of a specific multiplication-division Expresion
     *
     * @return				the left child (MulDivExpr)
     */
    @Override
    public MulDivExpr getLeftChild() {
        return leftChild;
    }

    /**
     * Get the right child of a specific multiplication-division Expresion
     *
     * @return				the right child (MulDivExpr)
     */
    @Override
    public MulDivExpr getRightChild() {
        return rightChild;
    }

    /**
     * Set the symbol (operator) a specific multiplication-division Expresion
     *
     * @param	s  	    the symbol (operator)
     */
    @Override
    public void setSymbol(String s) {
        symbol = s;
    }

    /**
     * Get the symbol (operator) a specific multiplication-division Expresion
     *
     * @return  	    the symbol (operator)
     */
    @Override
    public String getSymbol() {
        return symbol;
    }

}
