import java.util.*;
//import java.nio.file.*;
import java.io.*;

public class CharacterCount {
    public static void main (String[] args){
        // Read in filename.
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the name of the file you want to character-count: ");
        String filename = "";
        File f = new File(filename);
        while (!f.exists()){
            try {
                filename = scan.nextLine();
                f = new File(filename);
                if(!f.exists())
                    System.out.println("File does not exist, please enter the name of an existing file: ");
                else
                    break;
            } catch (Exception e){
               System.out.println("Invalid input, try again: ");
               continue;
            }
        }
        // Read in a SINGLE character.
        System.out.println("Enter a single character to look for in '" + filename+"': ");
        String c = "";
        while (c.length() != 1){
            try {
                c = scan.nextLine();
                if(c.length() != 1)
                    System.out.println("Invalid input, please enter a single character: ");
                else
                    break;
            } catch (Exception e){
               System.out.println("Invalid input, try again: ");
               continue;
            }
        }
        // Read every single line from the input file, iterate through every character in that line, and increase 'count' every single time we find it.
        int count = 0;
        try(BufferedReader buf = new BufferedReader(new FileReader(f.getAbsolutePath()))){
            String line = "";
            while((line = buf.readLine()) != null){
                for( char x : line.toCharArray() ){
                    if( x == c.charAt(0))
                        count++;
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        
        System.out.println("File '" + filename + "' contains the character '" + c + "' " + count +" many times." );
        scan.close();
    }
}
