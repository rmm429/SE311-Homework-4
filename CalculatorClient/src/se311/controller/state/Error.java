package se311.controller.state;

public class Error implements State {

    private State next;

    @Override
    public State handle(String button) {

        String log = this.getClass().getSimpleName() + ": " + button;

        next = new Start();
        log += " -> " + next.getClass().getSimpleName();

        System.out.println(log);
        return next;

    }
    
}
