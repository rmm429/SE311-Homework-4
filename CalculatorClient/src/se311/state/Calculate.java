package se311.state;

import se311.composite.AddSubExpr;
import se311.composite.Expression;
import se311.visitor.Visitor;

import java.util.ArrayList;

public class Calculate implements State {

    private State next;

    @Override
    public State handle(String button) {

        String log = this.getClass().getSimpleName() + ": " + button;

        next = new Start();
        log += " -> " + next.getClass().getSimpleName();

        System.out.println(log);
        return next;

    }

    public Expression buildTree(ArrayList<String> symbolList) {

        System.out.println(symbolList + "\n");

        Expression expressionTree = new AddSubExpr();
        return expressionTree;

    }
    
}
