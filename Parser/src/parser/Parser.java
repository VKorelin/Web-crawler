package parser;

import DAO.DataAccessLayer;
import DAO.Document;
import DAO.MSSQLConnection;
import java.io.IOException;
import java.util.ArrayList;

public class Parser {

    public static void main(String[] args) {
        DataAccessLayer dao = new DataAccessLayer();
        ParserManager pm = new ParserManager();
        Document doc = pm.Parse(".\\resources\\pdf\\Hello.pdf");
        dao.addCurrentDocumentToDB(doc);
        
        
    }
}
