package se311.view;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionListener;

// This view takes the subject role in an observer pattern
public class CalculatorView extends JFrame {

    private JLabel resultDisplay;
    private JPanel buttonGroup;

    public CalculatorView() {

        super("Simple Calculator");

        // Panel displaying results
        JPanel displayPanel = new JPanel();
        displayPanel.setBorder(BorderFactory.createCompoundBorder(
                new EmptyBorder(15, 0, 15, 0), // padding
                new LineBorder(Color.BLACK, 2))); // actual border
        add(displayPanel, BorderLayout.NORTH);

        // Text holding results
        resultDisplay = new JLabel("0");
        resultDisplay.setFont(new Font("Arial", Font.PLAIN, 30));
        displayPanel.add(resultDisplay);

        // Create the buttons

        buttonGroup = new JPanel();
        add(buttonGroup, BorderLayout.CENTER);
        buttonGroup.setLayout(new GridLayout(4, 4, 15, 15));

        String[] buttonStrings = {
                "7", "8", "9", "÷",
                "4", "5", "6", "×",
                "1", "2", "3", "-",
                "0", "C", "=", "+"
        };

        for (String s : buttonStrings) {

            JButton button = new JButton(s);
            button.setFont(new Font("Arial", Font.PLAIN, 30));
            setButtonColors(button, s);
            buttonGroup.add(button);

        }

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 400);
        setVisible(true);

    }

    // Add a listener registration function
    // embedded observer pattern
    public void attachListener(ActionListener listener) {

        for (Component b : buttonGroup.getComponents()) {
            ((JButton) b).addActionListener(listener);
        }

    }

    public void updateResults(String value) {
        resultDisplay.setText(value);
    }

    private void setButtonColors(JButton button, String s) {

        if (s.matches("÷|×|-|\\+|=")) {
            button.setBackground(Color.ORANGE);
            button.setForeground(Color.WHITE);

        } else if (s.equals("C")) {
            button.setBackground(Color.LIGHT_GRAY);
            button.setForeground(Color.BLACK);
        } else {
            button.setBackground(Color.DARK_GRAY);
            button.setForeground(Color.WHITE);
        }

        // Ensures color display on Mac
        button.setOpaque(true);

    }

}
