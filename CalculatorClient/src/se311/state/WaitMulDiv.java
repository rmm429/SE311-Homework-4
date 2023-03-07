package se311.state;

public class WaitMulDiv implements State {

    private State next;

    @Override
    public State handle(String button) {

        String log = "WaitMulDiv: " + button;

        if (button.matches("[0-9]")) {
            next = new CalMulDiv();
            log += " -> CalMulDiv";
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
