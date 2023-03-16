package se311.state;

public class GetAddSub implements State {

    private State next;

    @Override
    public State handle(String button) {

        String log = this.getClass().getSimpleName() + ": " + button;

        if (button.matches("[0-9]")) {
            next = new GetAddSub();
        } else if (button.matches("\\+|-")) {
            next = new WaitAddSub();
        } else if (button.matches("÷|×")) {
            next = new WaitMulDiv();
        } else if (button.matches("=")) {
            next = new Calculate();
        } else {
            next = new Start();
        }

        log += " -> " + next.getClass().getSimpleName();

        System.out.println(log);
        return next;

    }
    
}
