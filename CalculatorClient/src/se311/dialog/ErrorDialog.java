package se311.dialog;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ErrorDialog extends JFrame {

    // 0 = RESET
    // 1 = DISCARD
    private int selection;

    public ErrorDialog() {

        super("Error");

        String message = "You have entered an invalid command!\n" +
            "Would you like to reset the entire calculation or discard the invalid command?";
        String[] buttons = { "Reset", "Discard" };

        selection = JOptionPane.showOptionDialog(this, message, "Error",
                JOptionPane.YES_NO_OPTION, JOptionPane.ERROR_MESSAGE, null,
                buttons, buttons[0]);

//        setSize(350,350);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
//        setVisible(true);



//        JDialog dialog = new JDialog(this, "Error", true);
//        dialog.setLayout(new FlowLayout());
//        JButton resetButton = new JButton("Reset");
//        resetButton.addActionListener(e -> {
//            dialog.setVisible(false);
//        });
//        String message = "You have entered an invalid operation!\n" +
//                "Would you like to reset the calculation or discard the invalid operation?";
//        dialog.add(new JLabel(message));
//        dialog.add(resetButton);
//        dialog.setSize(300,300);
//        dialog.setVisible(true);





//        String message = "You have entered an invalid operation!\n" +
//                "Would you like to reset the calculation or discard the invalid operation?";
//
//        JOptionPane.showMessageDialog(this, message,"Error", JOptionPane.ERROR_MESSAGE);
//

    }

    /**
     * Returns the user-selected option from the dialog box
     * @return      int     the user-selected option
     */
    public int getSelection() {
        return selection;
    }

}
