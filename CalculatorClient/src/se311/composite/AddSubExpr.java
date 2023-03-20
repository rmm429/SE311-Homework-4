package se311.composite;

import se311.visitor.Visitor;

import java.util.ArrayList;

// Composite
public class AddSubExpr implements Expression {

    // --- Notes ---

    // left branch, right branch, root (operator)
    // root gets replaced with a number once the tree collapses (intermediate calculation)

    // current state is relevant (3 x 5 + 2) vs (3 + 5 x 2)

    // AddSub Composite can compose another AddSub (aggregation)
    // Don't need ArrayList, need left child and right child
    // Can be another AddSub, MulDiv, Atomic (which is MulDiv)

    // Since Atomic is MulDivExpr, AddSub can hold it
    // Follow the BNF

    @Override
    public void accept(Visitor visitor) {
        visitor.visitAddSubExpr(this);
    }



    // --- Method 3 attempted ---

//    private Expression operand1, operand2;
//    private String operator;
//
//    public AddSubExpr() {
//        operand1 = operand2 = null;
//        operator = "";
//    }
//
//    public AddSubExpr(Expression op1, String opr, Expression op2) {
//        operand1 = op1;
//        operator = opr;
//        operand2 = op2;
//    }
//
//    @Override
//    public void accept(Visitor visitor) {
//        visitor.visitAddSubExpr(this);
//    }
//
//    @Override
//    public void addOperand1(Expression op1) {
//        operand1 = op1;
//    }
//
//    @Override
//    public void addOperator(String opr) {
//        operator = opr;
//    }
//
//    @Override
//    public void addOperand2(Expression op2) {
//        operand2 = op2;
//    }



    // --- Method 2 attempted ---

//    private Expression leftChild, rightChild;
//    // dont make rightchild null for one expression
//    // otherwise, if there is only one child, don't use it
//
//    public AddSubExpr() {
//        leftChild = rightChild = null;
//    }
//
//    public AddSubExpr(Expression lc, Expression rc) {
//        leftChild = lc;
//        rightChild = rc;
//    }
//
//    @Override
//    public void accept(Visitor visitor) {
//        visitor.visitAddSubExpr(this);
//        leftChild.accept(visitor);
//        rightChild.accept(visitor);
//    }
//
//    public void addLeftChild(Expression lc) {
//        leftChild = lc;
//    }
//
//    public void addRightChild(Expression rc) {
//        rightChild = rc;
//    }
//
//    public void removeLeftChild() {
//        leftChild = null;
//    }
//
//    public void removeRightChild() {
//        rightChild = null;
//    }
//
//    public Expression getLeftChild() {
//        return leftChild;
//    }
//
//    public Expression getRightChild() {
//        return rightChild;
//    }


    // --- Method 1 attempted ---

//    private ArrayList<Expression> expressions;

//    public AddSubExpr() {
//        expressions = new ArrayList<>();
//    }

//    @Override
//    public void accept(Visitor visitor) {
//        visitor.visitAddSubExpr(this);
//        for (Expression exp : expressions) {
//            exp.accept(visitor);
//        }
//    }


//    @Override
//    public void operation() {
//
//    }

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
