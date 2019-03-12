import javax.swing.*;
import java.awt.event.*;

public class ErrorForm extends JDialog {
    private JPanel contentPane;
    private JTextField textField1;
    private JButton buttonOK;


    private ErrorForm() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);
        setTitle("Error!");
        setLocation(300, 300);
        textField1.setText("Error! Check your credentials!");

        buttonOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //setVisible(false);
                dispose();
            }
        });
    }

    static void run() {
        ErrorForm dialog = new ErrorForm();
        dialog.pack();
        dialog.setVisible(true);
    }
}
