package se311.dialog;

import javax.swing.*;

public class ErrorDialog extends JFrame {

    private int selection;

    public ErrorDialog() {

        super("Error");

        // Message to be displayed and button options
        String message = "You have entered an invalid command!\n" +
            "Would you like to reset the entire calculation or discard the invalid command?";
        String[] buttons = { "Reset", "Discard" };

        // Display the Dialog box
        selection = JOptionPane.showOptionDialog(this, message, "Error",
                JOptionPane.YES_NO_OPTION, JOptionPane.ERROR_MESSAGE, null,
                buttons, buttons[0]);

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

    }

    /**
     * Returns the user-selected option from the dialog box
     * 0 = RESET
     * 1 = DISCARD
     *
     * @return      int     the user-selected option
     */
    public int getSelection() {
        return selection;
    }

}
