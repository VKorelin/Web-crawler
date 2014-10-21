package parser.stemmers;

import junit.framework.TestCase;

public class StemmerManagerTest extends TestCase {
    
    public StemmerManagerTest(String testName) {
        super(testName);
    }
    
    /**
     * Test of getStem method, of class StemmerManager.
     */
    public void testEmptyWordGetStem() {
        System.out.println("getStem");
        String word = "";
        StemmerManager instance = new StemmerManager(new EnglishStemmer());
        String expResult = "";
        String result = instance.getStem(word);
        assertEquals(expResult, result);
    }
    
}
