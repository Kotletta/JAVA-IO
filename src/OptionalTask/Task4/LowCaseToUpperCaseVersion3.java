package OptionalTask.Task4;

import java.io.*;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LowCaseToUpperCaseVersion3 {
    public static void main(String[] args) {
        try(FileReader reader = new FileReader("data/SomeJavaCode.txt");
            BufferedReader bufferedReader = new BufferedReader(reader);
            FileWriter writer = new FileWriter("data/Task4.txt");
            BufferedWriter bufferedWriter = new BufferedWriter(writer)){

            String line = null;
            String word = null;
            StringBuffer buffer = new StringBuffer();
            Pattern pattern = Pattern.compile(".{2,}");

            while ((line = bufferedReader.readLine()) != null){
                Scanner scan = new Scanner(line);
                while (scan.hasNext()) {
                    word = scan.next();
                    Matcher matcher = pattern.matcher(word);
                    if (matcher.matches()){
                        for (int i = 0; i < word.length(); i++) {
                            buffer.append(matcher.group().toUpperCase() + " ");
                        }
                    } else{
                        buffer.append(word + " ");
                    }
                }
                bufferedWriter.write(buffer.toString(), 0, line.length());
                bufferedWriter.newLine();
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
