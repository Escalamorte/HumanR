import javax.swing.*;
import java.awt.event.*;

public class MainForm extends JDialog {
    private JPanel contentPane;
    private JTabbedPane tabbedPane1;
    private JFormattedTextField idField;
    private JFormattedTextField firstNameField;
    private JFormattedTextField lastNameField;
    private JFormattedTextField phoneField;
    private JFormattedTextField salaryField;
    private JButton hireButton;
    private JComboBox comboBox1;
    private JFormattedTextField birthdayField;
    private JRadioButton maleRadioButton;
    private JRadioButton femaleRadioButton;
    private JPanel genderPanel;
    private JLabel messageLabel;
    private JTable empTable;
    private JScrollPane jScrollPane;

    private JLabel lastName;
    private JLabel phone;
    private JLabel salary;

    private MainForm() {
        setContentPane(contentPane);
        setModal(true);
        setLocation(400, 200);
        createUIComponents();


        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(maleRadioButton);
        buttonGroup.add(femaleRadioButton);
        maleRadioButton.setSelected(true);

        idField.setText(String.valueOf(Employee.employees.size() + 1));

        hireButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                hire();
            }
        });
    }

//    private void employeesList(){
//        String[] headers = new String[]{"ID", "Name", "Phone"};
//        Object[][] data = {{"John", "Smith", "1112221"}};
//        JTable empTable = new JTable(data, headers);
//        jScrollPane = new JScrollPane(empTable);
//    }

    private void hire() {
        int id = Employee.employees.size() + 1;
        String name = firstNameField.getText() + " " + lastNameField.getText();
        String birthday = birthdayField.getText();
        String gender = "M";
        if (femaleRadioButton.isSelected()) {
            gender = "F";
        }
        String phone = comboBox1.getSelectedItem() + phoneField.getText();
        Double salary = Double.parseDouble(salaryField.getText());
        String status = "active";
        try {
            Employee employee = new Employee(id, name, birthday, gender, phone, salary, status);
            String result = employee.hire();

            messageLabel.setText(result);
        }catch (NullPointerException e) {
            System.out.println(e.getMessage());
        }
            idField.setText(String.valueOf(Employee.employees.size() + 1));

        eraseFields();
    }

    private void eraseFields() {
        firstNameField.setText("");
        lastNameField.setText("");
        birthdayField.setText("");
        phoneField.setText("");
        salaryField.setText("");
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }

    static void run () {
        MainForm dialog = new MainForm();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }

    private void createUIComponents() {
        String[] headers = new String[]{"ID", "Name", "Birthday", "Gender", "Phone", "Salary"};
        Object[][] data = {{"0001", "John Smith", "22.12.1989", "M", "1112221", "500.00"}};
        empTable = new JTable(data, headers);
    }
}