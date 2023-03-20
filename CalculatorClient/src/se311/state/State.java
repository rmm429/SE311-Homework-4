package se311.state;

// State in a State Pattern
public interface State {

    State getNextState(String button);
    void updateTree(String symbol);

}
