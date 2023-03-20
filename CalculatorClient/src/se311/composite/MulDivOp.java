package se311.composite;

import se311.visitor.Visitor;

// Composite
public class MulDivOp extends MulDivExpr {

    private MulDivExpr leftChild, rightChild;
    private String symbol;

    public MulDivOp() {
        leftChild = rightChild = null;
        symbol = "";
    }

    public MulDivOp(MulDivExpr lc, MulDivExpr rc) {
        leftChild = lc;
        rightChild = rc;
        symbol = "";
    }

    /**
     * Let a Visitor perform an operation on a specific multiplication-division operation
     *
     * @param	visitor	    a Visitor that handles a certain type of operation
     */
    @Override
    public void accept(Visitor visitor) {
        visitor.visitMulDivOp(this);
    }

    /**
     * Add an expression as the left child of a specific multiplication-division operation
     *
     * @param	lc  	    the Expression that will be added as the left child
     */
    @Override
    public void addLeftChild(Expression lc) {
        // Cast to MulDivExpr since a multiplication-division operation
        // can only contain other multiplication-division Expressions
        leftChild = (MulDivExpr) lc;
    }

    /**
     * Add an expression as the right child of a specific multiplication-division operation
     *
     * @param	rc  	    the Expression that will be added as the right child
     */
    @Override
    public void addRightChild(Expression rc) {
        // Cast to MulDivExpr since a multiplication-division operation
        // can only contain other multiplication-division Expressions
        rightChild = (MulDivExpr) rc;
    }

    /**
     * Remove the left child of a specific multiplication-division operation
     *
     */
    @Override
    public void removeLeftChild() {
        leftChild = null;
    }

    /**
     * Remove the right child of a specific multiplication-division operation
     *
     */
    @Override
    public void removeRightChild() {
        rightChild = null;
    }

    /**
     * Get the left child of a specific multiplication-division operation
     *
     * @return				the left child (MulDivExpr)
     */
    @Override
    public MulDivExpr getLeftChild() {
        return leftChild;
    }

    /**
     * Get the right child of a specific multiplication-division operation
     *
     * @return				the right child (MulDivExpr)
     */
    @Override
    public MulDivExpr getRightChild() {
        return rightChild;
    }

    /**
     * Set the symbol (operator) a specific multiplication-division operation
     *
     * @param	s  	    the symbol (operator)
     */
    @Override
    public void setSymbol(String s) {
        symbol = s;
    }

    /**
     * Get the symbol (operator) a specific multiplication-division operation
     *
     * @return  	    the symbol (operator)
     */
    @Override
    public String getSymbol() {
        return symbol;
    }

}
