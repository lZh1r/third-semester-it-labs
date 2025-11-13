package four;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.AccessDeniedException;
import java.util.Scanner;

public class TryCopy {
    public static void main(String[] args) {
        File sourceFile = new File("src/four/readFile.txt");
        try (
            Scanner myReader = new Scanner(sourceFile);
            FileWriter writer = new FileWriter("src/four/writeFile.txt");
        ) {
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                writer.write(data);
                if (myReader.hasNextLine()) writer.write("\n");
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (AccessDeniedException e) {
            System.out.println("Access denied");
        } catch (IOException e) {
            System.out.println("IO operation failed");
        }
    }
}
