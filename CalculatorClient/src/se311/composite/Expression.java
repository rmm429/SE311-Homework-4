package se311.composite;

import se311.visitor.Visitor;

// Component
public interface Expression {

    void accept(Visitor visitor);

    // --- Method 1 attempted ---

//    void operation();
//    void addChild(Expression child);
//    void removeChild(Expression child);
//    Expression getChild(int child);

    // --- Method 2 attempted ---

//    void addLeftChild(Expression lc);
//    void addRightChild(Expression rc);
//    void removeLeftChild();
//    void removeRightChild();
//    Expression getLeftChild();
//    Expression getRightChild();

}
