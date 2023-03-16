package se311.composite;

import se311.visitor.Visitor;

import java.util.ArrayList;

// Composite
public class MulDivExpr implements Expression {

    private ArrayList<Expression> expressions;

    public MulDivExpr() {
        expressions = new ArrayList<>();
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visitMulDivExpr(this);
        for (Expression exp : expressions) {
            exp.accept(visitor);
        }
    }

    @Override
    public void operation() {

    }

    @Override
    public void addChild(Expression child) {
        expressions.add(child);
    }

    @Override
    public void removeChild(Expression child) {
        expressions.remove(child);
    }

    @Override
    public Expression getChild(int child) {
        return expressions.get(child);
    }

}
