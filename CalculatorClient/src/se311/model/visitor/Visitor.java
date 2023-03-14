package se311.model.visitor;

import se311.model.composite.*;

public interface Visitor {

    // Each concrete Visitor (operation) will have different behaviors
    // depending on which concrete Composite it is visiting
    void visitAddSubExpr(AddSubExpr in);
    void visitMulDivExpr(MulDivExpr in);
    void visitMulDivOp(MulDivOp in);
    void visitAtomExpr(AtomExpr in);

}
