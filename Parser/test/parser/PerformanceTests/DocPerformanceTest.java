/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parser.PerformanceTests;

/**
 *
 * @author Vasily
 */

import java.io.File;
import junit.framework.TestCase;
import parser.DocParser;

public class DocPerformanceTest extends TestCase {
    
    public DocPerformanceTest(String testName){
        super(testName);
    }
    
    public void testParseSmallFile(){
        String filename = ".\\resources\\TestRes\\PerfTest\\doc\\small.doc";
        File file = new File(filename);
        long before = System.currentTimeMillis();
        String result = DocParser.parse(file);
        long after = System.currentTimeMillis();
        System.out.println("Small file parsing time - " + (after-before));
        assertTrue(result.length() > 0);
    }
    
    public void testParseMiddleFile(){
        String filename = ".\\resources\\TestRes\\PerfTest\\doc\\middle.doc";
        File file = new File(filename);
        long before = System.currentTimeMillis();
        String result = DocParser.parse(file);
        long after = System.currentTimeMillis();
        System.out.println("Middle file parsing time - " + (after-before));
        assertTrue(result.length() > 0);
    }
    
    public void testParseBigFile(){
        String filename = ".\\resources\\TestRes\\PerfTest\\doc\\big.doc";
        File file = new File(filename);
        long before = System.currentTimeMillis();
        String result = DocParser.parse(file);
        long after = System.currentTimeMillis();
        System.out.println("Big file parsing time - " + (after-before));
        assertTrue(result.length() > 0);
    }
}
