package se311.composite;

import se311.visitor.Visitor;

// Composite in a Composite pattern
public class AddSubExpr implements Expression {

    private Expression leftChild, rightChild;
    private String symbol;

    public AddSubExpr() {
        leftChild = rightChild = null;
        symbol = "";
    }

    public AddSubExpr(Expression lc, Expression rc) {
        leftChild = lc;
        rightChild = rc;
    }

    /**
     * Let a Visitor perform an operation on a specific addition-subtraction Expresion
     *
     * @param	visitor	    a Visitor that handles a certain type of operation
     */
    @Override
    public void accept(Visitor visitor) {
        visitor.visitAddSubExpr(this);
    }

    /**
     * Add an expression as the left child of a specific addition-subtraction Expresion
     *
     * @param	lc  	    the Expression that will be added as the left child
     */
    public void addLeftChild(Expression lc) {
        leftChild = lc;
    }

    /**
     * Add an expression as the right child of a specific addition-subtraction Expresion
     *
     * @param	rc  	    the Expression that will be added as the right child
     */
    public void addRightChild(Expression rc) {
        rightChild = rc;
    }

    /**
     * Remove the left child of a specific addition-subtraction Expresion
     *
     */
    public void removeLeftChild() {
        leftChild = null;
    }

    /**
     * Remove the right child of a specific addition-subtraction Expresion
     *
     */
    public void removeRightChild() {
        rightChild = null;
    }

    /**
     * Get the left child of a specific addition-subtraction Expresion
     *
     * @return				the left child (Expression)
     */
    public Expression getLeftChild() {
        return leftChild;
    }

    /**
     * Get the right child of a specific addition-subtraction Expresion
     *
     * @return				the right child (Expression)
     */
    public Expression getRightChild() {
        return rightChild;
    }

    /**
     * Set the symbol (operator) a specific addition-subtraction Expresion
     *
     * @param	s  	    the symbol (operator)
     */
    public void setSymbol(String s) {
        symbol = s;
    }

    /**
     * Get the symbol (operator) a specific addition-subtraction Expresion
     *
     * @return  	    the symbol (operator)
     */
    public String getSymbol() {
        return symbol;
    }

}
