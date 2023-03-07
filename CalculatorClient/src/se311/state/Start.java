package se311.state;

import java.awt.*;

public class Start implements State {

    private State next;

    @Override
    public State handle(String button) {

        String log = "Start: " + button;

        if (button.matches("[0-9]")) {
            next = new GetFirstOp();
            log += " -> GetFirstOp";
        } else {
            next = new Start();
            log += " -> Start";
        }

        System.out.println(log);
        return next;

    }

}
