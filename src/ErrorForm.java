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
        textField1.setText("Error! Check your credentials!");

        buttonOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //setVisible(false);
                dispose();
            }
        });

//        // call onOK() when cross is clicked
//        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
//        addWindowListener(new WindowAdapter() {
//            public void windowClosing(WindowEvent e) {
//                onOK();
//            }
//        });
//
//        // call onOK() on ESCAPE
//        contentPane.registerKeyboardAction(new ActionListener() {
//            public void actionPerformed(ActionEvent e) {
//                onOK();
//            }
//        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
    }

//    private void onOK() {
//        this.dispose();
//    }

    static void run() {
        ErrorForm dialog = new ErrorForm();
        dialog.pack();
        dialog.setVisible(true);
    }
}
