package se311.visitor;

import se311.composite.*;

// Visitor in a Visitor Pattern
public interface Visitor {

    // Each concrete Visitor (operation/method) will have different behaviors
    // depending on which concrete Composite it is visiting
    void visitAddSubExpr(AddSubExpr in);
    void visitMulDivExpr(MulDivExpr in);
    void visitMulDivOp(MulDivOp in);
    void visitAtomExpr(AtomExpr in);
    void clear();

}
