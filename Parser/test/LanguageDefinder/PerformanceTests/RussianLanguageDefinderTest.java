/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LanguageDefinder.PerformanceTests;

import junit.framework.TestCase;
import parser.ParserManager;
/**
 *
 * @author Vasily
 */
public class RussianLanguageDefinderTest extends TestCase {
    
    public RussianLanguageDefinderTest(String testName){
        super(testName);
    }
    
    public void testSmallText()
    {
        long before = System.currentTimeMillis();
        String lang = ParserManager.defineLang("Всем привет! Давайте тусить до утра!");
        long after = System.currentTimeMillis();
        System.out.println("Small text parsing time - " + (after-before));
        assertTrue(lang != null);
        assertTrue(lang == "ru");
    }
    
    public void testMiddleText()
    {
        long before = System.currentTimeMillis();
        String lang = ParserManager.defineLang("Всем привет! Давайте тусить до утра!");
        long after = System.currentTimeMillis();
        System.out.println("Small text parsing time - " + (after-before));
        assertTrue(lang != null);
        assertTrue(lang == "ru");
    }
}
