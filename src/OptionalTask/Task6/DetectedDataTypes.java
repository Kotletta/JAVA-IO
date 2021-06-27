package OptionalTask.Task6;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class DetectedDataTypes {
    public static void main(String[] args) {

        try (FileReader reader = new FileReader("data/Task6.txt")) {

            Scanner scan = new Scanner(reader);

            while (scan.hasNext()) {
                if (scan.hasNextBoolean()) {
                    System.out.println("Boolean type: " + scan.nextBoolean());
                } else if (scan.hasNextInt()) {
                    System.out.println("Int type: " + scan.nextInt());
                } else if (scan.hasNextDouble()) {
                    System.out.println("Double type: " + scan.nextDouble());

                } else if (scan.hasNext()) {
                    String string = scan.next();
                    if (string.length() == 1) {
                        System.out.println("Char type: " + string);
                    } else {
                        System.out.println("String type: " + string);
                    }
                }
            }

        }catch (FileNotFoundException e ){
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
