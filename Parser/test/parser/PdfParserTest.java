package parser;

import java.io.File;
import junit.framework.TestCase;

public class PdfParserTest extends TestCase {
    
    public PdfParserTest(String testName) {
        super(testName);
    }

     public void testNormalEnParse() {
        String filename = ".\\resources\\TestRes\\pdf\\Hello.pdf";
        File file = new File(filename);
        String expResult = "Hello!  \r\n \r\nHow  are you? \r\n";
        String result = PdfParser.parse(file);
        assertEquals(expResult, result);
    }

    public void testNullFileParse() {
        String expResult = null;
        String result = PdfParser.parse(null);
        assertEquals(expResult, result);
    }

    public void testEmptyFileParse() {
        String filename = ".\\resources\\TestRes\\pdf\\Empty.pdf";
        File file = new File(filename);
        String expResult = " \r\n";
        String result = PdfParser.parse(file);
        assertEquals(expResult, result);
    }
    
    public void testEnWithImageParse() {
        String filename = ".\\resources\\TestRes\\pdf\\HelloImg.pdf";
        File file = new File(filename);
        String expResult = "Hello!  \r\n \r\n \r\nHow  are you? \r\n";
        String result = PdfParser.parse(file);
        assertEquals(expResult, result);
    }
    
    public void testEnBigPdfParse() {
        String filename = ".\\resources\\TestRes\\pdf\\HelloBig.pdf";
        File file = new File(filename);
        String expResult = "Hello!  \r\n  \r\nHow  are you? \r\n";
        String result = PdfParser.parse(file);
        assertEquals(expResult, result);
    }
}
