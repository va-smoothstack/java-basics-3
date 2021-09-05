import java.util.Scanner;
import java.util.List;
import java.nio.file.*;
import java.util.stream.*;
import java.util.stream.Collectors;

public class DirectoryExplorer{
    public static void main(String [] args){
        // retrieve directory from user.
        Scanner scan = new Scanner(System.in);
        System.out.print("Please enter relative or absolute path to a directory: ");
        String dir = scan.nextLine();
        // create 'Path' object from the given path.
        Path path = Paths.get(dir).toAbsolutePath();
        List<Path> paths = null;
        // Walk the path
        try( Stream<Path> walk = Files.walk(path)){
            paths = walk.collect(Collectors.toList());
            paths.remove(0);    // Remove the first element (which just stores the given directory) to remove redundancy.
            for(Path p : paths)
                System.out.println(p);
        } catch (Exception e){
            System.out.println("Incorrect or Invalid Path.");
        }

        scan.close();
    }
}