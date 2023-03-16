package se311.composite;

import se311.visitor.Visitor;

// Leaf
public class AtomExpr extends MulDivExpr {

    @Override
    public void accept(Visitor visitor) {
        visitor.visitAtomExpr(this);
    }

    @Override
    public void operation() {

    }

}
