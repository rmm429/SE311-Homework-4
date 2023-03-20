package se311;

import se311.mvc.*;

import java.io.IOException;

public class Driver {

    public static void main(String[] args) throws IOException {

        View calculatorView = new View();
        Model model = new Model(calculatorView); // Model updates View
        Controller controller = new Controller(model); // Controller manipulates Model
        calculatorView.attachListener(controller); // View supplies Controller

    }

}
