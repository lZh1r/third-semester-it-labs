package four;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

public class CustomNumberFormatException extends NumberFormatException {
    public CustomNumberFormatException() {
        super();
    }

    public CustomNumberFormatException(String s) {
        super(s);
    }

    public static void main(String[] args) {
        try {
            System.out.println(tryParseInt("DSADS"));
        } catch (CustomNumberFormatException e) {
            File file = new File("logs.txt");
            try (FileWriter fw = new FileWriter("logs.txt")) {
                file.createNewFile();
                fw.write(e.getMessage());
                fw.write("\n");
                fw.write(Arrays.toString(e.getStackTrace()).replace("[", "").replace("]", "").replace(", ", "\n"));
            } catch (IOException ioException) {
                System.out.println(ioException.getMessage());
            }
        }
    }

    public static int tryParseInt(String s) throws CustomNumberFormatException {
        try {
            return Integer.parseInt(s);
        } catch (NumberFormatException e) {
            throw new CustomNumberFormatException(e.getMessage());
        }
    }
}
