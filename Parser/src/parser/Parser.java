package parser;

import DAO.DataAccessLayer;
import DAO.Document;
import DAO.MSSQLConnection;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Parser {

    public static void main(String[] args) {
<<<<<<< HEAD
        DataAccessLayer dao = new DataAccessLayer();
        ParserManager pm = new ParserManager();
        Document doc = pm.Parse(".\\resources\\pdf\\Hello.pdf");
        dao.addCurrentDocumentToDB(doc);
=======
        //DAO dao = new DAO();
        ParserManager pm = new ParserManager();
        try {
            Document doc = pm.Parse("http://www.yandex.ru");
            //dao.addDocumentToTDocument(doc);
        } catch (IOException ex) {
            Logger.getLogger(Parser.class.getName()).log(Level.SEVERE, null, ex);
        }
>>>>>>> bdbe19c1172d8ac75874e01eade804372b00a097
        
        
    }
}
