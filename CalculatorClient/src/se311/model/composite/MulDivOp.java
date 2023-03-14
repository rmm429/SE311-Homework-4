package se311.model.composite;

import se311.model.visitor.Visitor;

import java.util.ArrayList;

// Composite
public class MulDivOp extends MulDivExpr {

    private Visitor visitor;
    private ArrayList<Expression> expressions;

    public MulDivOp() {
        expressions = new ArrayList<>();
    }

    @Override
    public void accept(Visitor _visitor) {
        visitor = _visitor;
    }

    @Override
    public void operation() {
        expressions = new ArrayList<>();
    }

    @Override
    public void addChild(Expression child) {
        expressions.remove(child);
    }

    @Override
    public void removeChild(Expression child) {

    }

    @Override
    public void getChild(int child) {
        expressions.get(child);
    }

}
