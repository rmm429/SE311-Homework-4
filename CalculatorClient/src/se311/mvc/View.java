package se311.mvc;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionListener;

// This View takes the Subject role in an Observer Pattern
public class View extends JFrame {

    private JLabel resultDisplay;
    private JPanel buttonGroup;

    public View() {

        super("Simple Calculator");

        // Panel displaying results
        JPanel displayPanel = new JPanel();
        displayPanel.setBorder(BorderFactory.createCompoundBorder(
                new EmptyBorder(15, 0, 15, 0), // padding
                new LineBorder(Color.BLACK, 2))); // actual border
        add(displayPanel, BorderLayout.NORTH);

        // Text holding results
        resultDisplay = new JLabel(" ");
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

    /**
     * Add a listener registration function to each button
     *
     * @param	listener    listens for a button press
     */
    public void attachListener(ActionListener listener) {

        // Embedded Observer Pattern
        for (Component b : buttonGroup.getComponents()) {
            ((JButton) b).addActionListener(listener);
        }

    }

    /**
     * Display something in the panel
     *
     * @param	value	    the value to be displayed
     * @return				the word at the specified index in the list
     */
    public void updateDisplay(String value) {
        resultDisplay.setText(value);
    }

    /**
     * Set the buttons to certain colors based on their context in the Calculator view
     *
     * @param	button	    a button within the Calculator view
     * @param   label		the label of the button
     */
    private void setButtonColors(JButton button, String label) {
        
        if (label.matches("÷|×|-|\\+|=")) { // Orange operator buttons
            button.setBackground(Color.ORANGE);
            button.setForeground(Color.WHITE);
        } else if (label.equals("C")) { // Light gray clear button
            button.setBackground(Color.LIGHT_GRAY);
            button.setForeground(Color.BLACK);
        } else { // Dark gray number buttons
            button.setBackground(Color.DARK_GRAY);
            button.setForeground(Color.WHITE);
        }

        // Makes button colors display on Mac
        button.setOpaque(true);

    }

}
