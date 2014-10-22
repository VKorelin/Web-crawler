package parser;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.hwpf.extractor.WordExtractor;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class HtmlParser {

    public static String parse(File f) {
        if (f == null) {
            return null;
        }

        Document doc = null;
        try {
            doc = Jsoup.parse(f, "utf-8");
            // doc = Jsoup.connect("http://google.com/").get();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Elements elements = doc.body().select("*");
        String text = "";
        for (Element element : elements) {
            text = text + " " + element.ownText();
        }

        return text;
    }
}
