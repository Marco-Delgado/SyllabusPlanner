import java.io.*;
import java.util.Scanner;

public class Grading {
    public Grading (String text) throws IOException {

        //File file = new File(fileName+".txt");
        Scanner scanner = new Scanner(text);

            while (scanner.hasNextLine()) {
                    String current = scanner.nextLine();
                    if (current.endsWith("%")) {
                        System.out.println(current);
                    }
                    else if (current.endsWith("% ")) {
                        System.out.println(current);
                    }
            }
    scanner.close();
    }
}