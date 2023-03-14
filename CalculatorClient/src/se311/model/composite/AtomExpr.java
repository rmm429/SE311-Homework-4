package se311.model.composite;

import se311.model.visitor.Visitor;

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
