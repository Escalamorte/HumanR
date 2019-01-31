import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("***Welcome to HR System!***");

        Employee employee = new Employee();
        boolean exit = true;
        while (exit) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("\nTo view employees list press 1");
            System.out.println("To add new employees press 2");
            System.out.println("To edit employee information press 3");
            System.out.println("To calculate net salary press 4");
            System.out.println("To dismiss employee press 5");
            System.out.println("To exit press 0");


            int whatToDo;
            do {
                while (!scanner.hasNextInt()) {
                    System.out.println("Error! Choose from below");
                    scanner.next();
                }
                whatToDo = scanner.nextInt();
                if (whatToDo < 0 || whatToDo > 5) {
                    System.out.println("Error! Choose from below");
                }
            } while (whatToDo < 0 || whatToDo > 5);

            switch (whatToDo) {
                case 1: //list emp
                    if (employee.empID.size() == 0) {
                        System.out.println("Employee List is empty!");
                    } else {
                        for (int i = 0; i <= employee.empID.size() - 1; i++) {
                            System.out.print("\n" + employee.empID.get(i));
                            System.out.print("\t" + " | " +employee.empFirstName.get(i) + " ");
                            System.out.print(employee.empLastName.get(i));
                            System.out.print("\t" + " | " + employee.empSalary.get(i));
                            System.out.print("\t" + " | " + employee.empStatus.get(i));
                        }
                    }
                    break;
                case 2: //add emp
                    System.out.println("Enter First name: ");
                    String firstName = scanner.next();
                    System.out.println("Enter Last name: ");
                    String lastName = scanner.next();
                    System.out.println("Enter Salary: ");
                    double salary = scanner.nextDouble();

                    employee.empID.add(employee.empID.size() + 1);
                    employee.empFirstName.add(firstName);
                    employee.empLastName.add(lastName);
                    employee.empSalary.add(salary);
                    employee.empStatus.add("active");

                    System.out.println("Employee " + employee.empFirstName.get(employee.empID.size() - 1) + " "
                            + employee.empLastName.get(employee.empID.size() - 1)
                            + " with salary "
                            + employee.empSalary.get(employee.empID.size() - 1)
                            + " successfully added to ID "
                            + employee.empID.get(employee.empID.size() - 1));
                    break;
                case 3: //edit emp
                    System.out.println("Enter employee ID to edit:");
                    int idEdit = scanner.nextInt() - 1;
                    if (idEdit > employee.empID.size()) {
                        System.out.println("Error. Employee ID not found!");
                    } else {
                        System.out.println("Enter First name: ");
                        employee.empFirstName.set(idEdit, scanner.next());
                        System.out.println("Enter Last name: ");
                        employee.empLastName.set(idEdit, scanner.next());
                        System.out.println("Enter Salary: ");
                        employee.empSalary.set(idEdit, scanner.nextDouble());

                        System.out.println(employee.empFirstName.get(idEdit) + " "
                                + employee.empLastName.get(idEdit) + " | "
                                + employee.empSalary.get(idEdit)
                                + " successfully edited! ");
                    }
                    break;
                case 4: // calculate Net Salary
                    NetSal net = new NetSal();
                    for (int i = 0; i <= employee.empID.size() - 1; i++) {
                        System.out.print("\n" + employee.empID.get(i) + " | ");
                        System.out.print(employee.empFirstName.get(i) + " ");
                        System.out.print(employee.empLastName.get(i) + " | ");
                        System.out.print(net.calcSal(employee.empSalary.get(i)));
                    }
                    break;
                case 5: //dismiss
                    System.out.println("Enter employee ID to dismiss:");
                    int idDismiss = scanner.nextInt() - 1;
                    if (idDismiss > employee.empID.size()) {
                        System.out.println("Error! Employee not found!");
                    } else {
                        employee.empStatus.set(idDismiss, "dismiss");
                        System.out.println(employee.empFirstName.get(idDismiss) + " "
                                + employee.empLastName.get(idDismiss)
                                + " successfully dismissed! ");
                    }
                    break;
                case 0:
                    System.out.println("Bye!");
                    exit = false;
            }
        }
    }
}

