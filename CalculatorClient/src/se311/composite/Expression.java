package se311.composite;

import se311.visitor.Visitor;

// Component in a Composite pattern
public interface Expression {

    void accept(Visitor visitor);

    void addLeftChild(Expression lc);
    void addRightChild(Expression rc);
    void removeLeftChild();
    void removeRightChild();
    Expression getLeftChild();
    Expression getRightChild();
    void setSymbol(String s);
    String getSymbol();

}
