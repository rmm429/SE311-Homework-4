package se311.state;

public class WaitAddSub implements State {

    private State next;

    @Override
    public State handle(String button) {

        String log = "WaitAddSub: " + button;

        if (button.matches("[0-9]")) {
            next = new GetAddSub();
            log += " -> GetAddSub";
        } else if (button.matches("÷|×|-|\\+|=")) {
            next = new Error();
            log += " -> Error";
        } else {
            next = new Start();
            log += " -> Start";
        }

        System.out.println(log);
        return next;

    }
    
}
