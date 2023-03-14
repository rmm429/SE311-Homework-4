package se311.model.composite;

import se311.model.visitor.Visitor;

import java.util.ArrayList;

// Composite
public class MulDivOp extends MulDivExpr {

    private ArrayList<Expression> expressions;

    public MulDivOp() {
        expressions = new ArrayList<>();
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visitMulDivOp(this);
        for (Expression exp : expressions) {
            exp.accept(visitor);
        }
    }

    @Override
    public void operation() {
    }

    @Override
    public void addChild(Expression child) {
        expressions.remove(child);
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
