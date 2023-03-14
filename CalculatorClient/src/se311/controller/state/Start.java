package se311.controller.state;

public class Start implements State {

    private State next;

    @Override
    public State handle(String button) {

        String log = this.getClass().getSimpleName() + ": " + button;

        if (button.matches("[0-9]")) {
            next = new GetFirstOp();
        } else {
            next = new Start();
        }

        log += " -> " + next.getClass().getSimpleName();

        System.out.println(log);
        return next;

    }

}
