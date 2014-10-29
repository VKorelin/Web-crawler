package parser;

import DAO.DAO;
import DAO.Document;
import DAO.MSSQLConnection;
import java.io.IOException;
import java.util.ArrayList;

public class Parser {

    public static void main(String[] args) {
        /*MSSQLConnection ppp = new MSSQLConnection();
        ppp.getMSSQLConnection();
        ppp.closeMSSQLConnection();*/
        ParserManager pm = new ParserManager();
        pm.Parse("C:\\Users\\Vasily\\Documents\\NetBeansProjects\\Parser\\resources\\docx\\Hello.docx");
//        pm.Parse(".\\resources\\html\\Article.htm");
//        pm.Parse("C:\\Users\\Vasily\\Documents\\NetBeansProjects\\Parser\\resources\\doc\\Hello.doc");
//        pm.Parse("C:\\Users\\Vasily\\Documents\\NetBeansProjects\\Parser\\resources\\pdf\\Hello.pdf");
//        ArrayList<Document> docs = pm.MultipleParse("C:\\Users\\Vasily\\Documents\\NetBeansProjects\\Parser\\resources\\");

    }
}
