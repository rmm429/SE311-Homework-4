package se311.composite;

import se311.visitor.Visitor;

import java.util.ArrayList;

// Composite
public class AddSubExpr implements Expression {

    // left branch, right branch, root (operator)
    // root gets replaced with a number once the tree collapses (intermediate calculation)

    // current state is relevant (3 x 5 + 2) vs (3 + 5 x 2)

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
