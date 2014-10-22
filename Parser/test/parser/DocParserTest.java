package parser;

import java.io.File;
import junit.framework.TestCase;

public class DocParserTest extends TestCase {
    
    public DocParserTest(String testName) {
        super(testName);
    }

    public void testNormalEnParse() {
        String filename = ".\\resources\\TestRes\\doc\\Hello.doc";
        File file = new File(filename);
        String expResult = "Hello! \r\n\r\nHow  are you?\r\n\r\n";
        String result = DocParser.parse(file);
        assertEquals(expResult, result);
    }

    public void testNullFileParse() {
        String expResult = null;
        String result = DocParser.parse(null);
        assertEquals(expResult, result);
    }

    public void testEmptyFileParse() {
        String filename = ".\\resources\\TestRes\\doc\\Empty.doc";
        File file = new File(filename);
        String expResult = "\r\n\r\n";
        String result = DocParser.parse(file);
        assertEquals(expResult, result);
    }
    
    public void testEnWithImageParse() {
        String filename = ".\\resources\\TestRes\\doc\\HelloImg.doc";
        File file = new File(filename);
        String expResult = "Hello! \r\n\r\n\r\nHow  are you?\r\n\r\n";
        String result = DocParser.parse(file);
        assertEquals(expResult, result);
    }
    
    public void testEnBigDocParse() {
        String filename = ".\\resources\\TestRes\\doc\\HelloBig.doc";
        File file = new File(filename);
        String expResult = "Hello! \r\n\r\n\r\n\r\nHow  are you?\r\n\r\n";
        String result = DocParser.parse(file);
        assertEquals(expResult, result);
    }
}
