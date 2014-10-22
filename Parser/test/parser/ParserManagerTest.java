package parser;

import DAO.Document;
import junit.framework.TestCase;

public class ParserManagerTest extends TestCase {
    
    public ParserManagerTest(String testName) {
        super(testName);
    }

    public void testNullFileNameParse() {
        String filename = null;
        ParserManager instance = new ParserManager();
        Document result = instance.Parse(filename);
        Document expResult = null;
        assertEquals(expResult, result);
    }
    
    public void testEmptyStringNameParse() {
        String filename = "";
        ParserManager instance = new ParserManager();
        Document result = instance.Parse(filename);
        Document expResult = null;
        assertEquals(expResult, result);
    }
    
    public void testInvalidNameParse() {
        String filename = "rgfdopsfdpokpodkopk";
        ParserManager instance = new ParserManager();
        Document result = instance.Parse(filename);
        Document expResult = null;
        assertEquals(expResult, result);
    }
    
    public void testNotSupportedFormatNameParse() {
        String filename = "rgfdopsfdpokpodkopk.eqa";
        ParserManager instance = new ParserManager();
        Document result = instance.Parse(filename);
        Document expResult = null;
        assertEquals(expResult, result);
    }
    
}
