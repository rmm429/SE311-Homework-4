package se311.visitor;

import se311.composite.*;

public class Compute implements Visitor {

    private double result;

    public double doComputation(Expression expr) {
        expr.accept(this);
        return result;
    }

    @Override
    public void visitAddSubExpr(AddSubExpr in) {
        if (in.getLeftChild() instanceof AtomExpr && in.getRightChild() instanceof AtomExpr) {
            result = ((AtomExpr) in.getLeftChild()).getNumber() + ((AtomExpr) in.getRightChild()).getNumber();
        } else {
            System.out.println("BOTH NOT ATOM");
        }
    }

    @Override
    public void visitMulDivExpr(MulDivExpr in) {

    }

    @Override
    public void visitMulDivOp(MulDivOp in) {

    }

    @Override
    public void visitAtomExpr(AtomExpr in) {
        result = in.getNumber();
        System.out.println(result);
    }

}
