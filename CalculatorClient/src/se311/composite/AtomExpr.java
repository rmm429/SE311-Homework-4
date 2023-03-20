package se311.composite;

import se311.visitor.Visitor;

// Leaf
public class AtomExpr extends MulDivExpr {

    private double number;

    public AtomExpr() {
        number = 0.0;
    }

    public AtomExpr(double n) {
        number = n;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visitAtomExpr(this);
    }

    public double getNumber() {
        return number;
    }

    public void setNumber(double n) {
        number = n;
    }

//    @Override
//    public void operation() {
//
//    }

}
