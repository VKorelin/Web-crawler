package parser;

import java.io.File;
import java.util.ArrayList;
import junit.framework.TestCase;

public class PdfParserTest extends TestCase {
    
    public PdfParserTest(String testName) {
        super(testName);
    }

    /**
     * Test of parse method, of class PdfParser.
     */
    public void testNormalEnParse() {
        String filename = "C:\\Users\\Vasily\\Documents\\NetBeansProjects\\Parser\\resources\\TestRes\\pdf\\Hello.pdf";
        File file = new File(filename);
        ArrayList<String> expResult = new ArrayList<>();
        expResult.add("hello");
        expResult.add("how");
        expResult.add("ar");
        expResult.add("you");
        String result = PdfParser.parse(file);
        assertEquals(expResult, result);
    }

    public void testNullFileParse() {
        ArrayList<String> expResult = null;
        String result = PdfParser.parse(null);
        assertEquals(expResult, result);
    }

    public void testEmptyFileParse() {
        System.out.println("parse");
        String filename = "C:\\Users\\Vasily\\Documents\\NetBeansProjects\\Parser\\resources\\TestRes\\pdf\\Empty.pdf";
        File file = new File(filename);
        String expResult = "\r\n";
        String result = PdfParser.parse(file);
        assertEquals(expResult, result);
    }
    
    public void testEnWithImageParse() {
        System.out.println("parse");
        String filename = "C:\\Users\\Vasily\\Documents\\NetBeansProjects\\Parser\\resources\\TestRes\\pdf\\HelloImg.pdf";
        File file = new File(filename);
        ArrayList<String> expResult = new ArrayList<>();
        expResult.add("hello");
        expResult.add("how");
        expResult.add("ar");
        expResult.add("you");
        String result = PdfParser.parse(file);
        assertEquals(expResult, result);
    }
    
    public void testEnBigDocParse() {
        System.out.println("parse");
        String filename = "C:\\Users\\Vasily\\Documents\\NetBeansProjects\\Parser\\resources\\TestRes\\pdf\\HelloBig.pdf";
        File file = new File(filename);
        ArrayList<String> expResult = new ArrayList<>();
        expResult.add("hello");
        expResult.add("how");
        expResult.add("ar");
        expResult.add("you");
        String result = PdfParser.parse(file);
        assertEquals(expResult, result);
    }
}
