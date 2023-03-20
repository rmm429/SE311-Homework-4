package se311.composite;

import se311.visitor.Visitor;

import java.util.ArrayList;

// Composite
public abstract class MulDivExpr implements Expression {

    private Expression leftChild, rightChild;

    public MulDivExpr() {
        leftChild = rightChild = null;
    }

    public MulDivExpr(Expression lc, Expression rc) {
        leftChild = lc;
        rightChild = rc;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visitMulDivExpr(this);
        leftChild.accept(visitor);
        rightChild.accept(visitor);
    }

    public void addLeftChild(Expression lc) {
        leftChild = lc;
    }

    public void addRightChild(Expression rc) {
        rightChild = rc;
    }

    public void removeLeftChild() {
        leftChild = null;
    }

    public void removeRightChild() {
        rightChild = null;
    }

    public Expression getLeftChild() {
        return leftChild;
    }

    public Expression getRightChild() {
        return rightChild;
    }

//    private ArrayList<Expression> expressions;
//
//    public MulDivExpr() {
//        expressions = new ArrayList<>();
//    }
//
//    @Override
//    public void accept(Visitor visitor) {
//        visitor.visitMulDivExpr(this);
//        for (Expression exp : expressions) {
//            exp.accept(visitor);
//        }
//    }
//
//    @Override
//    public void operation() {
//
//    }
//
//    @Override
//    public void addChild(Expression child) {
//        expressions.add(child);
//    }
//
//    @Override
//    public void removeChild(Expression child) {
//        expressions.remove(child);
//    }
//
//    @Override
//    public Expression getChild(int child) {
//        return expressions.get(child);
//    }

}
