package se311.composite;

import se311.visitor.Visitor;

// Leaf in a Composite pattern
public class AtomExpr extends MulDivExpr {

    private String symbol;

    public AtomExpr() {
        symbol = "";
    }

    public AtomExpr(String s) {
        symbol = s;
    }

    /**
     * Let a Visitor perform an operation on a specific atomic Expression
     *
     * @param	visitor	    a Visitor that handles a certain type of operation
     */
    @Override
    public void accept(Visitor visitor) {
        visitor.visitAtomExpr(this);
    }

    /**
     * Set the symbol (number) a specific atomic Expression
     *
     * @param	s  	    the symbol (number)
     */
    @Override
    public void setSymbol(String s) {
        symbol = s;
    }

    /**
     * Get the symbol (number) a specific atomic Expression
     *
     * @return  	    the symbol (number)
     */
    @Override
    public String getSymbol() {
        return symbol;
    }

}
