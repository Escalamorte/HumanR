import java.util.ArrayList;

public class Employee {

    private int empId;
    private String empName;
    private String empBirthday;
    private String empGender;
    private String empPhone;
    private Double empSalary;
    private String empStatus;
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

    public int getEmpId () {
        System.out.println(empId);
        return empId;
    }

    public String getEmpName () {
        System.out.println(empName);
        return empName;
    }

    public String getEmpBirthday() {
        System.out.println(empBirthday);
        return empBirthday;
    }

    public String getEmpGender() {
        System.out.println(empGender);
        return empGender;
    }

    public String getEmpPhone() {
        System.out.println(empPhone);
        return empPhone;
    }

    public Double getEmpSalary() {
        return empSalary;
    }

    public String getEmpStatus() {
        return empStatus;
    }

}
