package parser;

import java.io.File;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.util.PDFTextStripper;

public class PdfParser {

    public static String parse(File file) {
        if(file == null){
            return null;
        }
        
        String text = "";
        
        try {
            try (PDDocument pddDocument = PDDocument.load(file)) {
                PDFTextStripper textStripper = new PDFTextStripper();
                text = textStripper.getText(pddDocument);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        
        return text;
    }
}
