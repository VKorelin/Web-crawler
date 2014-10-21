package parser;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;

import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.hwpf.extractor.WordExtractor;

public class DocParser {

    public static String parse(File file) {
        if(file == null) {
            return null;
        }
        
        String text = "";
        try {            
            try (FileInputStream fis = new FileInputStream(file.getAbsolutePath())) {
                HWPFDocument doc = new HWPFDocument(fis);
                try (WordExtractor docText = new WordExtractor(doc)) {
                    text = docText.getText();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return text;
    }
}
