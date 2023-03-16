package se311;

import se311.dialog.ErrorDialog;
import se311.mvc.Controller;
import se311.mvc.Model;
import se311.mvc.View;

public class Driver {

    public static void main(String[] args) {

        // Instantiate calculator view here, pass to controller
        // Make model class and pass model to controller, pass the view to the model (model updates view)
        // Controller needs to know what model it is manipulating

        View calculatorView = new View();
        Model model = new Model(calculatorView); // Model updates View
        Controller controller = new Controller(model); // Controller manipulates Model
        calculatorView.attachListener(controller); // View supplies Controller

    }

}
