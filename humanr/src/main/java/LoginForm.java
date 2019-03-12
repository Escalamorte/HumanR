import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.event.*;

public class LoginForm extends JDialog{
    private JPanel contentPanel;
    private JFormattedTextField loginTextField1;
    private JButton login;
    private JLabel logoLabel;
    private JPasswordField passField;


    private LoginForm() {
        setContentPane(contentPanel);
        setModal(true);
        setTitle("HumanR | Login");
        setLocation(400, 200);
        getRootPane().setDefaultButton(login);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        login.setEnabled(false);

        loginTextField1.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {}

            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER &&
                        !loginTextField1.getText().equals("") &&
                        passField.getPassword().length != 0) login();
            }

            @Override
            public void keyReleased(KeyEvent e) {}
        });

        loginTextField1.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                loginButtonActivator();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                loginButtonActivator();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                loginButtonActivator();
            }
        });

        passField.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                loginButtonActivator();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                loginButtonActivator();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                loginButtonActivator();
            }
        });

        login.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {login(); }
        });
    }

    private void loginButtonActivator() {
        if(loginTextField1.getText().equals("") || passField.getPassword().length == 0) {
            login.setEnabled(false);
        } else {
            login.setEnabled(true);
        }
    }

    private void login() {
        String userName = loginTextField1.getText();
        String pass = new String(passField.getPassword());
        if (userName.equalsIgnoreCase("admin") && pass.equals("123456") ) {
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