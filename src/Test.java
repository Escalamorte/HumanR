import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Test extends JDialog {
    private JPanel contentPane;
    private JScrollPane jScrollPane;
    private JTable jTable;



    Test() {
        setContentPane(contentPane);
        setModal(true);
        createUIComponents();
    }

    public static void main(String[] args) {
        Test dialog = new Test();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }

    private void createUIComponents() {
        String[] headers = new String[]{"ID", "Name", "Phone"};
        Object[][] data = {{"John", "Smith", "1112221"}};
        jTable = new JTable(data, headers);
    }
}
