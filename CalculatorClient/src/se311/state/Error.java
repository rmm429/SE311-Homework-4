package se311.state;

public class Error implements State {

    private State next;

    @Override
    public State handle(String button) {

        String log = "Error: " + button;

        next = new Start();
        log += " -> Start";

        System.out.println(log);
        return next;

    }
    
}
