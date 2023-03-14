package se311.model.composite;

import se311.model.visitor.Visitor;

// Leaf
public class AtomExpr extends MulDivExpr {

    private Visitor visitor;

    @Override
    public void accept(Visitor _visitor) {
        visitor = _visitor;
    }

    @Override
    public void operation() {

    }

}
