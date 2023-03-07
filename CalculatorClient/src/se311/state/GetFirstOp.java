package se311.state;

public class GetFirstOp implements State {

    private State next;

    @Override
    public State handle(String button) {

        String log = "GetFirstOp: " + button;

        if (button.matches("[0-9]")) {
            next = new GetFirstOp();
            log += " -> GetFirstOp";
        } else if (button.matches("\\+|-")) {
            next = new WaitAddSub();
            log += " -> WaitAddSub";
        } else if (button.matches("÷|×")) {
            next = new WaitMulDiv();
            log += " -> WaitMultDiv";
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
