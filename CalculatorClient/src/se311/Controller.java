package se311;

import se311.controller.state.*;
import se311.view.CalculatorView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller {

    public static void main(String[] args) {

        CalculatorHandler handler = new CalculatorHandler();
        handler.init();

    }

}
