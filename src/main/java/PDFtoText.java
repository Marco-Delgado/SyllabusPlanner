import java.io.File;
import java.io.IOException;
import java.io.FileWriter;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.encryption.AccessPermission;
import org.apache.pdfbox.text.PDFTextStripper;

public class PDFtoText {

    public PDFtoText(File pdfFile, String fileName) throws IOException {


        try (PDDocument document = PDDocument.load(pdfFile)) {
            AccessPermission ap = document.getCurrentAccessPermission();
            if (!ap.canExtractContent())
                throw new IOException("You do not have permission to extract text");

            PDFTextStripper stripper = new PDFTextStripper();
            stripper.setSortByPosition(true);

            for (int p=1; p <= document.getNumberOfPages(); ++p) {
                String text = stripper.getText(document);

                String pageStr = String.format("page %d:", p);

                    File sylName = new File(fileName+".txt");
                    FileWriter mySyl = new FileWriter(fileName+".txt");
                    mySyl.write(text.trim());
                    mySyl.close();



//                System.out.println(pageStr);
//                for (int i = 0; i < pageStr.length(); ++i) {
//                    System.out.print("-");
//                }
//                System.out.println();
//                System.out.println(text.trim());
//                System.out.println();
            }
            System.out.println("Finished txt!");
        }

    }
}
