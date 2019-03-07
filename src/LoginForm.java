import javax.swing.*;
import java.awt.event.*;

public class LoginForm extends JDialog{
    private JPanel contentPane;
    private JPasswordField passwordField1;
    private JFormattedTextField loginTextField1;
    private JButton login;

    LoginForm() {
        setContentPane(contentPane);
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
        LoginForm dialog = new LoginForm();
        dialog.pack();
        dialog.setVisible(true);
    }
}
