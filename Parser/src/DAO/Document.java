package DAO;

import java.util.HashMap;

public class Document {

    private HashMap<String, Integer> invertedIdx;
    private String title;
    private String author;
    private String extension;
    private String text;
    private String date;

    public Document() {

    }

    public Document(String title, String author, String extension, String text, String date) {
        this.title = title;
        this.author = author;
        this.extension = extension;
        this.text = text;
        this.date = date;
    }

    public Document(String text, HashMap<String, Integer> invertedIdx, String ext) {
        this.text = text;
        this.invertedIdx = invertedIdx;
        this.extension = ext;
    }

    public Document(Document document) {
        this.title = document.title;
        this.author = document.author;
        this.extension = document.extension;
        this.text = document.text;
        this.date = document.date;
    }

    public HashMap<String, Integer> getInvertedIdx() {
        return invertedIdx;
    }

    public void setInvertedIdx(HashMap<String, Integer> invertedIdx) {
        this.invertedIdx = invertedIdx;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

}
