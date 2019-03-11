import javax.swing.*;
import java.awt.event.*;

public class LoginForm extends JDialog{
    private JPanel contentPanel;
    private JFormattedTextField loginTextField1;
    private JButton login;
    private JLabel logoLabel;


    private LoginForm() {
        setContentPane(contentPanel);
        setModal(true);
        setTitle("HumanR v2");
        setLocation(400, 200);
        getRootPane().setDefaultButton(login);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);


        login.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {login(); }
        });

        loginTextField1.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {}

            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) login();
            }

            @Override
            public void keyReleased(KeyEvent e) {}
        });
    }

    private void login() {
        String userName = loginTextField1.getText();
        if (userName.equalsIgnoreCase("admin")) {
            dispose();
            MainForm.run();
        } else {
            ErrorForm.run();
        }
    }

    static void run() {
        try {
            LoginForm dialog = new LoginForm();
            dialog.pack();
            dialog.setVisible(true);
        } catch (NullPointerException e) {
            throw new IllegalStateException("null argument", e);
        }
    }
}
