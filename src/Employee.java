import java.util.ArrayList;

public class Employee {
    private static int empId;
    private static String empName;
    private static String empBirthday;
    private static String empGender;
    private static String empPhone;
    private static Double empSalary;
    private static String empStatus;
    static ArrayList<Employee> employees = new ArrayList<>();

    Employee(int id, String name, String birthday, String gender, String phone, Double salary, String status) {
        this.empId = id;
        this.empName = name;
        this.empBirthday = birthday;
        this.empGender = gender;
        this.empPhone = phone;
        this.empSalary = salary;
        this.empStatus = status;
    }

    String hire () {
        employees.add(new Employee(empId, empName, empBirthday, empGender, empPhone, empSalary, empStatus));
        DateFile.editData();
        getEmpId();
        getEmpName();
        getEmpBirthday();
        getEmpGender();
        getEmpPhone();
        return "Success";
    }

    static int getEmpId () {
        System.out.println(empId);
        return empId;
    }

    static String getEmpName () {
        System.out.println(empName);
        return empName;
    }

    static String getEmpBirthday() {
        System.out.println(empBirthday);
        return empBirthday;
    }

    static String getEmpGender() {
        System.out.println(empGender);
        return empGender;
    }

    static String getEmpPhone() {
        System.out.println(empPhone);
        return empPhone;
    }

    static Double getEmpSalary() {
        return empSalary;
    }

    static String getEmpStatus() {
        return empStatus;
    }

}
