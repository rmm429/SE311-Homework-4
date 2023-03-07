package se311.state;

public class Calculate implements State {

    private State next;

    @Override
    public State handle(String button) {

        String log = "Calculate: " + button;

        next = new Start();
        log += " -> Start";

        System.out.println(log);
        return next;

    }
    
}
