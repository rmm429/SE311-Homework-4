package se311.state;

public interface State {

    State handle(String button);

}
