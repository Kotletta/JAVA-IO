package OptionalTask.Task1;
//Создать и заполнить файл случайными целыми числами. Отсортировать содержимое файла по возрастанию.

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class createFile {
    public static void main(String[] args) {
        File directory = new File("data");
        directory.mkdir();

        try (FileWriter file = new FileWriter("data/File.txt")){
            file.write(String.valueOf(sortArray(createArrayList(10))));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<Integer> createArrayList (int count){
        ArrayList<Integer> arrayList = new ArrayList<Integer>(count);
        for (int i = 0; i < count; i++) {
            arrayList.add((int)(Math.random()*10));
        }
        return arrayList;
    }

    public static ArrayList<Integer> sortArray (ArrayList<Integer> arrayList){
        Collections.sort(arrayList);
        return arrayList;
    }
}
