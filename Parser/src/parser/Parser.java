package parser;

import DAO.DAO;
import DAO.Document;
import DAO.MSSQLConnection;
import java.io.IOException;
import java.util.ArrayList;

public class Parser {

    public static void main(String[] args) {
        DAO dao = new DAO();
        ParserManager pm = new ParserManager();
        Document doc = pm.Parse(".\\resources\\pdf\\Hello.pdf");
        dao.addDocumentToTDocument(doc);
        
        
    }
}
