package se311.model.composite;

import se311.model.visitor.Visitor;

import java.util.ArrayList;

// Composite
public class AddSubExpr implements Expression {

    // AddSub Composite can compose another AddSub (aggregation)
    // Don't need ArrayList, need left child and right child
    // Can be another AddSub, MulDiv, Atomic (which is MulDiv)

    // Since Atomic is MulDivExpr, AddSub can hold it
    // Follow the BNF

    private ArrayList<Expression> expressions;

    public AddSubExpr() {
        expressions = new ArrayList<>();
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visitAddSubExpr(this);
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
