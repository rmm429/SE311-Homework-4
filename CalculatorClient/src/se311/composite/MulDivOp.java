package se311.composite;

import se311.visitor.Visitor;

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

    public void addChild(MulDivExpr child) {
        expressions.remove(child);
    }

    public void removeChild(MulDivExpr child) {
        expressions.remove(child);
    }

    @Override
    public Expression getChild(int child) {
        return expressions.get(child);
    }

}
