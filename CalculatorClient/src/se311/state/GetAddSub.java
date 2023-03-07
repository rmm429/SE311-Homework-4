package se311.state;

public class GetAddSub implements State {

    private State next;

    @Override
    public State handle(String button) {

        String log = "GetAddSub: " + button;

        if (button.matches("[0-9]")) {
            next = new GetAddSub();
            log += " -> GetAddSub";
        } else if (button.matches("\\+|-")) {
            next = new WaitAddSub();
            log += " -> WaitAddSub";
        } else if (button.matches("÷|×")) {
            next = new WaitMulDiv();
            log += " -> WaitMulDiv";
        } else if (button.matches("=")) {
            next = new Calculate();
            log += " -> Calculate";
        } else {
            next = new Start();
            log += " -> Start";
        }

        System.out.println(log);
        return next;

    }
    
}
