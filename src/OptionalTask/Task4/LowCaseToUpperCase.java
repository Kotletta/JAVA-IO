package OptionalTask.Task4;

import java.io.*;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LowCaseToUpperCase {
    public static void main(String[] args) {
        try (FileReader reader = new FileReader("data/SomeJavaCode.txt");
             BufferedReader bufferedReader = new BufferedReader(reader);
             FileWriter writer = new FileWriter("data/Task4.txt");
             BufferedWriter bufferedWriter = new BufferedWriter(writer)) {

            String line = null;
            String word = null;
            StringBuilder buffer = new StringBuilder();
            Pattern pattern = Pattern.compile(".{2,}");
            Scanner scan = null;
            int offset = 0;

            while ((line = bufferedReader.readLine()) != null) {
                scan = new Scanner(line);
                while (scan.hasNext()) {
                    word = scan.next();
                    Matcher matcher = pattern.matcher(word);
                    if (matcher.matches()) {
                        buffer.append(matcher.group().toUpperCase() + " ");
                    } else {
                        buffer.append(word + " ");
                    }
                }
                bufferedWriter.write(buffer.toString(), offset, (buffer.length() - offset));
                bufferedWriter.newLine();
                offset = buffer.length();
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
