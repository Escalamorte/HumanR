import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

class DateFile {
    private static String fileName = "data";
    private static String dir = System.getProperty("user.dir");
    private static String fullName = dir + "\\src" + File.separator + fileName;
    private static File data = new File(fullName);

    private static void createDataFile () {
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
            editData();
        } else {
            if (data.canWrite()) {
                try {
                    FileOutputStream dateFile = new FileOutputStream(fullName);
                        //dateFile.write();

                } catch (IOException e) {
                    System.out.println(e);
                }
            }
        }
    }

//    public static void main(String[] args) {
//        editData();
//    }
}
