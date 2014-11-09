package parser;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.hwpf.extractor.WordExtractor;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class HtmlParser {

    public static String parse(String webAddress, ArrayList<String> linksList) {
        if (webAddress == null) {
            return null;
        }

        Document doc = null;
        try {
            doc = Jsoup.connect(webAddress).get();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        return getString(doc, linksList);
    }
    
    public static String parse(File f, ArrayList<String> linksList) {
        if (f == null) {
            return null;
        }
        Document doc = null;
        try {
            doc = Jsoup.parse(f, "utf-8");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return getString(doc, linksList);
    }
    
    private static String getString(Document doc, ArrayList<String> linksList){
        Elements links = doc.select("a[href]");
        Elements elements = doc.body().select("*");
        String text = "";
        for (Element element : elements) {
            text = text + " " + element.ownText();
        }
        
        linksList = new ArrayList<String>();
        for (Element link : links) {
            linksList.add(link.attr("abs:href"));
        }

        return text;
    }
}
