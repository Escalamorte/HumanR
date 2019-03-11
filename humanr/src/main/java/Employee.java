import java.util.ArrayList;

class Employee {
    private static int empId;
    private static String empName;
    private static String empBirthday;
    private static String empGender;
    private static String empPhone;
    private static Double empSalary;
    private static String empStatus;
    static ArrayList<Employee> employees = new ArrayList<>();

    Employee(int id, String name, String birthday, String gender, String phone, Double salary, String status) {
        empId = id;
        empName = name;
        empBirthday = birthday;
        empGender = gender;
        empPhone = phone;
        empSalary = salary;
        empStatus = status;
    }

    String hire () {
        employees.add(new Employee(empId, empName, empBirthday, empGender, empPhone, empSalary, empStatus));
        DateFile.createDataFile();
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
