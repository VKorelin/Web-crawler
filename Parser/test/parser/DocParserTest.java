package parser;

import java.io.File;
import java.util.ArrayList;
import junit.framework.TestCase;

public class DocParserTest extends TestCase {
    
    public DocParserTest(String testName) {
        super(testName);
    }

    public void testNormalEnParse() {
        String filename = "C:\\Users\\Vasily\\Documents\\NetBeansProjects\\Parser\\resources\\TestRes\\doc\\Hello.doc";
        File file = new File(filename);
        ArrayList<String> expResult = new ArrayList<>();
        expResult.add("hello");
        expResult.add("how");
        expResult.add("ar");
        expResult.add("you");
        String result = DocParser.parse(file);
        assertEquals(expResult, result);
    }

    public void testNullFileParse() {
        ArrayList<String> expResult = null;
        String result = DocParser.parse(null);
        assertEquals(expResult, result);
    }

    public void testEmptyFileParse() {
        System.out.println("parse");
        String filename = "C:\\Users\\Vasily\\Documents\\NetBeansProjects\\Parser\\resources\\TestRes\\doc\\Empty.doc";
        File file = new File(filename);
        ArrayList<String> expResult = new ArrayList<>();
        String result = DocParser.parse(file);
        assertEquals(expResult, result);
    }
    
    public void testEnWithImageParse() {
        System.out.println("parse");
        String filename = "C:\\Users\\Vasily\\Documents\\NetBeansProjects\\Parser\\resources\\TestRes\\doc\\HelloImg.doc";
        File file = new File(filename);
        ArrayList<String> expResult = new ArrayList<>();
        expResult.add("hello");
        expResult.add("how");
        expResult.add("ar");
        expResult.add("you");
        String result = DocParser.parse(file);
        assertEquals(expResult, result);
    }
    
    public void testEnBigDocParse() {
        System.out.println("parse");
        String filename = "C:\\Users\\Vasily\\Documents\\NetBeansProjects\\Parser\\resources\\TestRes\\doc\\HelloBig.doc";
        File file = new File(filename);
        ArrayList<String> expResult = new ArrayList<>();
        expResult.add("hello");
        expResult.add("how");
        expResult.add("ar");
        expResult.add("you");
        String result = DocParser.parse(file);
        assertEquals(expResult, result);
    }
}
