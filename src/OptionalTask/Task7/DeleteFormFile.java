package OptionalTask.Task7;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class DeleteFormFile {
    public static void main(String[] args) {
        String path = "data/Task7.txt";
        readFile(path).forEach(System.out::println);
        deleteWords(path);
    }


    public static List<String> readFile(String path) {
        List<String> text = null;
        try {
            text = Files.readAllLines(Paths.get(path));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return text;
    }


    public static int numberOfIncorrectWordsInALine(String line) {
        int count = 0;
        String[] words = lineToWords(line);
        for (String word : words) {
            if (word.length() >= 3 & word.length() <= 5) {
                count++;
            }
        }
        ;
        return count;
    }


    public static String[] lineToWords(String line) {
        line.trim();
        String[] words = line.split(" ");
        return words;
    }

    public static String deleteWordsInLine(String line) {
        StringBuffer buffer = new StringBuffer("");
        int countWrongWords = numberOfIncorrectWordsInALine(line);
        String[] words = lineToWords(line);

        while (countWrongWords > 0) {
            if (countWrongWords % 2 != 0) {
                countWrongWords--;
            }
            for (String word : words) {
                if (word.length() < 3 | word.length() > 5) {
                    buffer.append(word).append(" ");

                } else {
                    countWrongWords--;
                }

            }
        }
        return buffer.toString().trim();
    }

    public static void deleteWords(String path) {
        List<String> text = new ArrayList<>();
        for (String line : readFile(path)) {
            text.add(deleteWordsInLine(line));
        }
        writeFile(path, text);

    }

    public static void writeFile(String path, List<String> text) {
        try (FileWriter writer = new FileWriter(path);
             BufferedWriter bufferedWriter = new BufferedWriter(writer)) {
            for (String line : text) {
                bufferedWriter.write(line);
                bufferedWriter.newLine();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
