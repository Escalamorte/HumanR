import java.io.*;
import java.util.Scanner;

class DateFile {
    private static String fileName = "data.txt";
    private static String dir = System.getProperty("user.dir");
    private static String fullName = dir + "\\humanr\\src\\main\\resources" + File.separator + fileName;
    private static File data = new File(fullName);

    static void createDataFile () {
        if(!data.exists()) {
            try{
                if(data.createNewFile()) {
                    System.out.println("File created");
                } else {
                    System.out.println("Error");
                }
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }else {
            System.out.println("File already exist at " + fullName);
        }
    }

    static void editData() {
        if (!data.exists()) {
            createDataFile();
        } else {
            if (data.canWrite()) {
                try {
                    FileWriter fileWriter = new FileWriter(fullName);
                        fileWriter.write(
                                  Employee.getEmpId() +
                                "|" + Employee.getEmpName() +
                                "|" + Employee.getEmpBirthday() +
                                "|" + Employee.getEmpGender() +
                                "|" + Employee.getEmpPhone() +
                                "|" + Employee.getEmpSalary() +
                                "|" + Employee.getEmpStatus() + "\n");

                        fileWriter.close();

                } catch (IOException e) {
                    System.out.println(e);
                }
            }
        }
    }

    static String readData() {
        if (!data.exists()) {
            return ("No file in directory");
        } else {
            if (data.canRead()) {
                try {
                    FileReader fileReader = new FileReader(fullName);
                    Scanner sc = new Scanner(fileReader);
                    while (sc.hasNextLine()) {
                        System.out.println(sc.nextLine());
                    }
                    fileReader.close();
                } catch (IOException e ) {
                    System.out.println(e.getMessage());
                }
            } else {
                return "File can't read";
            }
            return "File can't read";
        }
    }
}
