package OptionalTask.Task2;

import java.io.*;

public class PublicReplacePrivate {
    public static void main(String[] args) {
        {
            try (FileWriter writer = new FileWriter("data/Task2.txt");
                 BufferedWriter bufferedWriter = new BufferedWriter(writer);
                 FileReader reader = new FileReader("data/SomeJavaCode.txt");
                 BufferedReader bufferedReader = new BufferedReader(reader)) {
                 String line = null;

                while ((line = bufferedReader.readLine()) != null) {
                    line = line.replaceAll("public", "private");
                    bufferedWriter.write(line, 0, line.length());
                    bufferedWriter.newLine();
                }

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
