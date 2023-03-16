package se311.composite;

import se311.visitor.Visitor;

// Component
public interface Expression {

    void accept(Visitor visitor);
    void operation();
    void addChild(Expression child);
    void removeChild(Expression child);
    Expression getChild(int child);

}
