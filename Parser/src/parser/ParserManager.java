package parser;

import DAO.Document;
import java.io.*;
import java.util.ArrayList;
import java.util.Dictionary;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import me.champeau.ld.UberLanguageDetector;
import parser.stemmers.EnglishStemmer;
import parser.stemmers.RussianStemmer;
import parser.stemmers.StemmerManager;

public class ParserManager {

    private File file;
    private ArrayList<String> docTerms;

    public ParserManager() {
    }

    public Document Parse(String filename) {
        if (filename == null) {
            return null;
        }
        file = new File(filename);

        int extPos = file.getName().lastIndexOf('.');
        if (extPos == -1) {
            return null;
        }

        String text = "";
        String extension = file.getName().substring(extPos);

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
                text = HtmlParser.parse(file);
                break;
            default:
                return null;
        }

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

        for (String stem : stemOfDocWords) {
            System.out.println(stem + "\r");
        }
        
        HashMap<String, Integer> invertedIdx = new HashMap<>();
        for (String word: stemOfDocWords){
            if(invertedIdx.containsKey(word)){
                int value = invertedIdx.get(word);
                invertedIdx.put(word, value++);
            }
            else{
                invertedIdx.put(word, 1);
            }
        }

        return new Document(text, invertedIdx, extension);
    }

    public static String defineLang(String text) {
        UberLanguageDetector detector = UberLanguageDetector.getInstance();
	return detector.detectLang(text);
    }

    public ArrayList<Document> MultipleParse(String folderName) /*throws IOException */{
        ArrayList<File> files = new ArrayList<>();
        ArrayList<Document> docs = new ArrayList<Document>();
        FindDocs(files, folderName);

        for (File f : files) {
            docs.add(Parse(f.getAbsolutePath()));
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
}
