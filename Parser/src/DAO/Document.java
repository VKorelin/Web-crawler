package DAO;

import java.util.HashMap;

public class Document {
    private HashMap<String, Integer> invertedIdx;
    private String extension;
    private String text;
    
    public Document(String text, HashMap<String, Integer> invertedIdx, String ext)
    {
        this.text = text;
        this.invertedIdx = invertedIdx;
        this.extension = ext;
    }
}
