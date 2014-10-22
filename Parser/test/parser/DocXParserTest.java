package parser;

import java.io.File;
import junit.framework.TestCase;

public class DocXParserTest extends TestCase {

    public DocXParserTest(String testName) {
        super(testName);
    }
    
    public void testNormalEnParse() {
        String filename = ".\\resources\\TestRes\\docx\\Hello.docx";
        File file = new File(filename);
        String expResult = "Hello! \n\nHow  are you?\n";
        String result = DocXParser.parse(file);
        assertEquals(expResult, result);
    }

    public void testNullFileParse() {
        String expResult = null;
        String result = DocXParser.parse(null);
        assertEquals(expResult, result);
    }

    public void testEmptyFileParse() {
        String filename = ".\\resources\\TestRes\\docx\\Empty.docx";
        File file = new File(filename);
        String expResult = "";
        String result = DocXParser.parse(file);
        assertEquals(expResult, result);
    }
    
    public void testEnWithImageParse() {
        String filename = ".\\resources\\TestRes\\docx\\HelloImg.docx";
        File file = new File(filename);
        String expResult = "Hello! \n\n\nHow  are you?\n";
        String result = DocXParser.parse(file);
        assertEquals(expResult, result);
    }
    
    public void testEnBigDocXParse() {
        String filename = ".\\resources\\TestRes\\docx\\HelloBig.docx";
        File file = new File(filename);
        String expResult = "Hello! \n\n\nHow  are you?\n";
        String result = DocXParser.parse(file);
        assertEquals(expResult, result);
    }
}
