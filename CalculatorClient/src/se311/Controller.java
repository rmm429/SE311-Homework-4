package se311;

import se311.state.*;
import se311.view.CalculatorView;

import java.awt.event.ActionListener;
import java.util.concurrent.atomic.AtomicReference;

public class Controller {

    public static State current;
    public static CalculatorView calc;

    public static void main(String[] args) {

        calc = new CalculatorView();

        // Set initial State to Start in the State Machine
        current = new Start();

        request();

    }

    public static void request() {

        // Observer in the Observer Pattern
        ActionListener listener = action -> {
            String command = action.getActionCommand();
            calc.updateResults(command);
            // Context in the State Pattern
            current = current.handle(command);
        };
        calc.attachListener(listener);

    }

}
