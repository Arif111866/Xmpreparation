import java.io.*;
import java.text.*;
import java.util.*;

public class StudentList {
    public static String students;
    public static String[] studentsName;

    public static void Read() {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(Constant.fileName)));
            students = reader.readLine();
            studentsName = students.split(Constant.coma);
            reader.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void Write(String Text) {
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(Constant.fileName, false));
            bufferedWriter.flush();
            bufferedWriter.write(Text);
            bufferedWriter.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void main(String[] args) {

        if (args.length == 0) {
            System.out.println(Constant.error);
        } else if (args[0].equals(Constant.showAll)) {
            System.out.println(Constant.loadingInfo);
            Read();
            for (String name : studentsName) {
                System.out.println(name);
            }
            System.out.println(Constant.loaded);
        } else if (args[0].equals(Constant.showRandom)) {
            System.out.println(Constant.loadingInfo);
            Read();
            Random random = new Random();
            System.out.println(studentsName[random.nextInt(studentsName.length)]);
            System.out.println(Constant.loaded);
        } else if (args[0].contains(Constant.addWord)) {
            System.out.println(Constant.loadingInfo);
            Read();
            Date d = new Date();
            DateFormat dateFormat = new SimpleDateFormat(Constant.DateFormate);
            String text = students + Constant.coma + args[0].substring(1) + Constant.updateInfo + dateFormat.format(d);
            Write(text);
            System.out.println(Constant.loaded);
        } else if (args[0].contains(Constant.findWord)) {
            System.out.println(Constant.loadingInfo);
            Read();
            for (String name : studentsName) {
                if (name.equals(args[0].substring(1))) {
                    System.out.println(Constant.FoundMessage);
                    break;
                }
            }
            System.out.println(Constant.loaded);
        } else if (args[0].contains(Constant.countStudent)) {
            System.out.println(Constant.loadingInfo);
            System.out.print(studentsName.length);
            System.out.println(Constant.foundMessage);
            System.out.println(Constant.loaded);
        } else {
            System.out.println(Constant.error);
        }
    }
}
