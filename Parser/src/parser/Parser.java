package parser;

import Crawler.CrawlerInstance;
import DAO.DAO;
import DAO.Document;
import DAO.MSSQLConnection;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Parser {

    public static void main(String[] args) throws IOException {
        Crawler.CrawlerInstance crawler = new CrawlerInstance("http://www.apmath.spbu.ru", "apmath.spbu.ru");
        crawler.Start(false);
    }
}
