package parser;

import java.io.FileInputStream;
import java.io.InputStream;
import java.io.File;

import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.apache.poi.xwpf.usermodel.XWPFDocument;

public class DocXParser {

    public static String parse(File file) {
        if (file == null) {
            return null;
        }

        String text = "";
        try {
            InputStream in = new FileInputStream(file);
            XWPFDocument docIn = new XWPFDocument(in);
            try (XWPFWordExtractor extractor = new XWPFWordExtractor(docIn)) {
                text = extractor.getText();
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return text;
    }
}
