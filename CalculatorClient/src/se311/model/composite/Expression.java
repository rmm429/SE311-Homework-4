package se311.model.composite;

import se311.model.visitor.Visitor;

// Component
public interface Expression {

    void accept(Visitor _visitor);
    void operation();
    void addChild(Expression child);
    void removeChild(Expression child);
    void getChild(int child);

}
