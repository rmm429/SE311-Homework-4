package se311.model.composite;

import se311.model.visitor.Visitor;

// Component
public interface Expression {

    void accept(Visitor visitor);
    void operation();
    void addChild(Expression child);
    void removeChild(Expression child);
    Expression getChild(int child);

}
