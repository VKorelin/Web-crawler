/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import DAO.DAO;
import DAO.Document;
import DAO.Term;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import parser.ParserManager;

/**
 *
 * @author User
 */
public class DAOTest {

    public DAOTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of addDataToTDocument method, of class DAO.
     */
    @Test
    public void testAddDataToTDocument() {
        System.out.println("addDataToTDocument");
        ParserManager pm = new ParserManager();
        List<Document> documents = null;
        documents = pm.MultipleParse(".//resources");
        DAO instance = new DAO();
        instance.addDataToTDocument(documents);
    }

    /**
     * Test of addDataToTTerm method, of class DAO.
     */
    @Test
    public void testAddDataToTTerm() {
        System.out.println("addDataToTTerm");
        List<Term> terms = null;
        DAO instance = new DAO();
        instance.addDataToTTerm(terms);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addTermToTTerm method, of class DAO.
     */
    @Test
    public void testAddTermToTTerm() {
        System.out.println("addTermToTTerm");
        ParserManager pm = new ParserManager();
        DAO instance = new DAO();
        Term term = new Term("comi", 3);
        Document document = pm.Parse(".\\resources\\pdf\\Hello.pdf");
        instance.addTermToTTerm(term);
    }

    /**
     * Test of addDocumentToTDocument method, of class DAO.
     */
    @Test
    public void testAddDocumentToTDocument() {
        System.out.println("addDocumentToTDocument");
        ParserManager pm = new ParserManager();
        DAO instance = new DAO();
        Document document = pm.Parse(".\\resources\\pdf\\Hello.pdf");
        instance.addDocumentToTDocument(document);
    }

}
