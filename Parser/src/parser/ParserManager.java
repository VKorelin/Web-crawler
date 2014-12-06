package parser;

import DAO.Document;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.HashMap;
import me.champeau.ld.UberLanguageDetector;
import parser.stemmers.EnglishStemmer;
import parser.stemmers.RussianStemmer;
import parser.stemmers.StemmerManager;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jsoup.Jsoup;
import org.jsoup.select.Elements;

public class ParserManager {

    private File file;
    private ArrayList<String> docTerms;

    public ParserManager() {
    }

    public Document Parse(String filename, boolean parseText) throws MalformedURLException, IOException {
        if (filename == null) {
            return null;
        }

        String text = "";
        String extension = "";

        HashMap<String, Integer> invertedIdx = new HashMap<>();

        HtmlParser htmlParser = null;

        if (isWebAddress(filename)) {
            htmlParser = new HtmlParser(filename, parseText);
            htmlParser.parse();
            extension = filename;
        } else {
            file = new File(filename);

            int extPos = file.getName().lastIndexOf('.');
            if (extPos == -1) {
                return null;
            }

            extension = file.getName().substring(extPos);

            switch (extension) {
                case ".docx":
                    text = DocXParser.parse(file);
                    break;
                case ".doc":
                    text = DocParser.parse(file);
                    break;
                case ".pdf":
                    text = PdfParser.parse(file);
                    break;
                case ".htm":
                case ".html":
                    htmlParser = new HtmlParser(filename, parseText);
                    htmlParser.parse(file);
                    break;
                default:
                    return null;
            }
        }

        if (parseText) {
            ArrayList<String> stemOfDocWords = new ArrayList<>();

            StemmerManager sManager = null;

            switch (defineLang(text)) {
                case "ru":
                    sManager = new StemmerManager(new RussianStemmer());
                    break;
                case "en":
                    sManager = new StemmerManager(new EnglishStemmer());
                    break;
                default:
                    return null;
            }

            String[] strValues = text.split("(?!['])[\\p{Punct}\\d\\s|\\r]+");
            for (String word : strValues) {
                stemOfDocWords.add(sManager.getStem(word));
            }

            for (String word : stemOfDocWords) {
                if (invertedIdx.containsKey(word)) {
                    int value = invertedIdx.get(word);
                    invertedIdx.put(word, value++);
                } else {
                    invertedIdx.put(word, 1);
                }
            }
        }
        return new Document(text, invertedIdx, extension, htmlParser);
    }

    public static String defineLang(String text) {
        /*UberLanguageDetector detector = UberLanguageDetector.getInstance();
         return detector.detectLang(text);*/
        return "en";
    }

    public ArrayList<Document> MultipleParse(String folderName) throws IOException {
        ArrayList<File> files = new ArrayList<>();
        ArrayList<Document> docs = new ArrayList<Document>();
        FindDocs(files, folderName);

        for (File f : files) {
            docs.add(Parse(f.getAbsolutePath(), true));
        }
        return docs;
    }

    private void FindDocs(ArrayList<File> files, String folderName) {
        File folder = new File(folderName);
        File[] folderFiles = folder.listFiles();
        for (File f : folderFiles) {
            if (f.isDirectory()) {
                FindDocs(files, f.getAbsolutePath());
            }
            if (f.isFile()) {
                files.add(f);
            }
        }
    }

    boolean isWebAddress(String url) throws MalformedURLException, IOException {
        /*URL url1 = new URL("http://www.example.com");
         HttpURLConnection huc = (HttpURLConnection) url1.openConnection();
         int responseCode = huc.getResponseCode();

         if (responseCode != 404) {
         return true;
         } else {
         return false;
         }*/
        return true;
    }
}
