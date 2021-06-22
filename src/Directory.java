import java.io.File;
import java.util.Scanner;

public class Directory {
    public static void main(String[] args) {
        String path = readDirecoty();
        showStructure(path);
    }
    public static String readDirecoty() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the path to the directory: ");
        String path = scan.nextLine();
        return  path;
    }

    public static void showStructure (String path) {
        File file = new File(path);
        String[] structure = null;
        if (file.exists()) {
            if(file.isDirectory()){
                showStructureOfDirecoty(file);
            }
        }
    }
    public static void showStructureOfDirecoty(File file){
        for (File item : file.listFiles()) {
            if (item.isDirectory()){
                System.out.println("--- " + item.getName());
                String str = file+item.getName();
            } else {
                System.out.println("+++ " + item.getName());
            }
        }
    }
}
