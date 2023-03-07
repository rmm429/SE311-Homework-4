package se311.composite;

public interface Expression {

    void operation();
    void addChild(Expression child);
    void removeChild(Expression child);
    void getChild(int child);

}
