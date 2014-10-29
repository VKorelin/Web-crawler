/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LanguageDefinder.PerformanceTests;

import java.io.File;
import static junit.framework.Assert.assertTrue;
import junit.framework.TestCase;
import parser.ParserManager;
import parser.PdfParser;
/**
 *
 * @author Vasily
 */
public class EnglishLanguageDefinderTest extends TestCase {
    
    public EnglishLanguageDefinderTest(String testName){
        super(testName);
    }
    
    public void testText()
    {
        long before = System.currentTimeMillis();
        String lang = ParserManager.defineLang("Hello everyone! \n \n \n \n \r \n \rLet's have fun!!!");
        long after = System.currentTimeMillis();
        System.out.println("Text parsing time - " + (after-before));
        assertTrue(lang != null);
        assertTrue(lang == "en");
    }
    
    public void testSmallText()
    {
        String filename = ".\\resources\\TestRes\\PerfTest\\pdf\\small.pdf";
        File file = new File(filename);
        String result = PdfParser.parse(file);
        long before = System.currentTimeMillis();
        String lang = ParserManager.defineLang(result);
        long after = System.currentTimeMillis();
        System.out.println("Small text parsing time - " + (after-before));
        assertTrue(lang != null);
        assertTrue(lang == "en");
    }
    
    public void testMiddleText()
    {
        String filename = ".\\resources\\TestRes\\PerfTest\\pdf\\middle.pdf";
        File file = new File(filename);
        String result = PdfParser.parse(file);
        long before = System.currentTimeMillis();
        String lang = ParserManager.defineLang(result);
        long after = System.currentTimeMillis();
        System.out.println("Middle text parsing time - " + (after-before));
        assertTrue(lang != null);
        assertTrue(lang == "en");
    }
    
    public void testBigText()
    {
        String filename = ".\\resources\\TestRes\\PerfTest\\pdf\\big.pdf";
        File file = new File(filename);
        String result = PdfParser.parse(file);
        long before = System.currentTimeMillis();
        String lang = ParserManager.defineLang(result);
        long after = System.currentTimeMillis();
        System.out.println("Middle big parsing time - " + (after-before));
        assertTrue(lang != null);
        assertTrue(lang == "en");
    }
}
