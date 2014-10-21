package parser;

import java.io.File;
import java.util.ArrayList;
import junit.framework.TestCase;

public class DocXParserTest extends TestCase {

    public DocXParserTest(String testName) {
        super(testName);
    }

    public void testNormalEnParse() {
        String filename = "C:\\Users\\Vasily\\Documents\\NetBeansProjects\\Parser\\resources\\TestRes\\docx\\Hello.docx";
        File file = new File(filename);
        String expResult = "";
        String result = DocXParser.parse(file);
        assertEquals(expResult, result);
    }

    public void testNullFileParse() {
        ArrayList<String> expResult = null;
        String result = DocXParser.parse(null);
        assertEquals(expResult, result);
    }

    public void testEmptyFileParse() {
        System.out.println("parse");
        String filename = "C:\\Users\\Vasily\\Documents\\NetBeansProjects\\Parser\\resources\\TestRes\\docx\\Empty.docx";
        File file = new File(filename);
        ArrayList<String> expResult = new ArrayList<>();
        String result = DocXParser.parse(file);
        assertEquals(expResult, result);
    }
    
    public void testEnWithImageParse() {
        System.out.println("parse");
        String filename = "C:\\Users\\Vasily\\Documents\\NetBeansProjects\\Parser\\resources\\TestRes\\docx\\HelloImg.docx";
        File file = new File(filename);
        ArrayList<String> expResult = new ArrayList<>();
        expResult.add("hello");
        expResult.add("how");
        expResult.add("ar");
        expResult.add("you");
        String result = DocXParser.parse(file);
        assertEquals(expResult, result);
    }
    
    public void testEnBigDocParse() {
        System.out.println("parse");
        String filename = "C:\\Users\\Vasily\\Documents\\NetBeansProjects\\Parser\\resources\\TestRes\\docx\\HelloBig.docx";
        File file = new File(filename);
        ArrayList<String> expResult = new ArrayList<>();
        expResult.add("hello");
        expResult.add("how");
        expResult.add("ar");
        expResult.add("you");
        String result = DocXParser.parse(file);
        assertEquals(expResult, result);
    }
}
