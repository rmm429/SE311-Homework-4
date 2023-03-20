package se311.composite;

import se311.visitor.Visitor;

import java.util.ArrayList;

// Composite
public class MulDivOp extends MulDivExpr {

    private Expression leftChild, rightChild;

    public MulDivOp() {
        leftChild = rightChild = null;
    }

    public MulDivOp(Expression lc, Expression rc) {
        leftChild = lc;
        rightChild = rc;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visitMulDivOp(this);
        leftChild.accept(visitor);
        rightChild.accept(visitor);
    }

    public void addLeftChild(MulDivExpr lc) {
        leftChild = lc;
    }

    public void addRightChild(MulDivExpr rc) {
        rightChild = rc;
    }

    @Override
    public void removeLeftChild() {
        leftChild = null;
    }

    @Override
    public void removeRightChild() {
        rightChild = null;
    }

    @Override
    public Expression getLeftChild() {
        return leftChild;
    }

    @Override
    public Expression getRightChild() {
        return rightChild;
    }

//    private ArrayList<Expression> expressions;
//
//    public MulDivOp() {
//        expressions = new ArrayList<>();
//    }
//
//    @Override
//    public void accept(Visitor visitor) {
//        visitor.visitMulDivOp(this);
//        for (Expression exp : expressions) {
//            exp.accept(visitor);
//        }
//    }
//
//    @Override
//    public void operation() {
//    }
//
//    public void addChild(MulDivExpr child) {
//        expressions.remove(child);
//    }
//
//    public void removeChild(MulDivExpr child) {
//        expressions.remove(child);
//    }
//
//    @Override
//    public Expression getChild(int child) {
//        return expressions.get(child);
//    }

}
