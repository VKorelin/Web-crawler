/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parser;

/**
 *
 * @author Vasily
 */

import java.io.File;
import junit.framework.TestCase;

public class HtmlParserTest extends TestCase {
    
    public HtmlParserTest(String testName){
        super(testName);
    }

     public void testNormalEnParse() {
        String filename = ".\\resources\\TestRes\\html\\Hello.html";
        File file = new File(filename);
        String expResult = "      Hello!         How�are you?";
        String result = HtmlParser.parse(file);
        assertEquals(expResult, result);
    }

    public void testNullFileParse() {
        String expResult = null;
        String result = HtmlParser.parse(null);
        assertEquals(expResult, result);
    }

    public void testEmptyFileParse() {
        String filename = ".\\resources\\TestRes\\html\\Empty.html";
        File file = new File(filename);
        String expResult = "    ";
        String result = HtmlParser.parse(file);
        assertEquals(expResult, result);
    }
    
    public void testEnWithImageParse() {
        String filename = ".\\resources\\TestRes\\html\\HelloImg.html";
        File file = new File(filename);
        String expResult = "      Hello!                 How are you? ";
        String result = HtmlParser.parse(file);
        assertEquals(expResult, result);
    }
}
