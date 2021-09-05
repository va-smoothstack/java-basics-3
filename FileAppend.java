import java.util.*;
import java.nio.file.*;
import java.io.*;

public class FileAppend {
    public static void main(String [] args){
        // Ask user what file they'd like to write to.
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter the name of the exsisting file you wish to append to: ");
        String filename = scan.nextLine();
        File file = new File(filename);
        // Check if file even exists, if not, terminate.
        if(!file.exists()){
            System.out.println("File '" + filename + "' does not exist.");
            System.exit(0);
        }
        // Ask user to input text they wish to append.
        System.out.print("Enter text you wish to append to '" + filename + "' : ");
        byte[] buffer = scan.nextLine().getBytes();
        try {        
            Files.write(Paths.get(filename), buffer, StandardOpenOption.APPEND);   // Write to desired file.
        } catch (Exception e) {
            System.out.println("Something went wrong: " +e);
        }
        scan.close();
    }
}
