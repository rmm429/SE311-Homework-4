package se311.state;

public class WaitMulDiv implements State {

    private State next;

    @Override
    public State handle(String button) {

        String log = this.getClass().getSimpleName() + ": " + button;

        if (button.matches("[0-9]")) {
            next = new CalMulDiv();
        } else if (button.matches("÷|×|-|\\+|=")) {
            next = new Error();
        } else {
            next = new Start();
        }

        log += " -> " + next.getClass().getSimpleName();

        System.out.println(log);
        return next;

    }
    
}
