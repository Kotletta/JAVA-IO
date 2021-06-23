package OptionalTask.Task5;

import java.io.*;
import java.util.ArrayList;

public class ToLowerCaseByMark {
    public static void main(String[] args) throws FileNotFoundException {
        ArrayList<String> studets = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("data/StudentRatings.txt"))) {
            while (bufferedReader.ready()){
                String string = bufferedReader.readLine();
                StringBuilder stringBuilder = new StringBuilder();
                int grade = Integer.parseInt(string.replaceAll("[^0-9]", ""));
                if (grade > 7) {
                    stringBuilder.append(string.substring(0, string.indexOf(" ")).toUpperCase()).append(" ").append(grade);
                }else{
                    stringBuilder.append(string, 0, string.indexOf(" ")).append(" ").append(grade);
                }
                studets.add(stringBuilder.toString());
            }
        } catch (IOException e) {
            e.getMessage();
        }

        try (FileWriter writer = new FileWriter("data/Task5.txt")) {
            for (String student: studets) {
                writer.write(student + "\n");
            }
        } catch (IOException e ){
            e.getMessage();
        }
    }
}
