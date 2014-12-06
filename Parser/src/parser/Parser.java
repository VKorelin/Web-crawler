package parser;

import DAO.DAO;
import DAO.Document;
import DAO.MSSQLConnection;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Parser {

    public static void main(String[] args) {
        //DAO dao = new DAO();
        ParserManager pm = new ParserManager();
        try {
            Document doc = pm.Parse("http://www.yandex.ru");
            //dao.addDocumentToTDocument(doc);
        } catch (IOException ex) {
            Logger.getLogger(Parser.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
}
