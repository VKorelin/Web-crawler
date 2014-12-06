package Crawler;

import DAO.Document;
import com.sun.istack.internal.FinalArrayList;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import parser.Parser;
import parser.ParserManager;

public class CrawlerInstance {

    String startURL;
    String domainName;

    static int goodLinksCount = 0;
    static int totalCountOfJSLinks=  0;
    static int totalNumberOfFailedToDownloadLinks = 0;
    static int numberOfExceptions = 0;

    static int numberOfPdf = 0;
    static int numberOfWordDoc = 0;
    static int numberOfDjvuDoc = 0;
    static int numberOfExelDoc = 0;
    static int numberOfImages = 0;
    static int numberOfPowerPointDocs = 0;
    static int numberOfArchieves = 0;

    ArrayList<String> badURLs;
    ArrayList<String> failedToDownloadUrls;
    static HashSet<String> visitedLinks;
    static HashSet<String> queue;
    static ArrayList<String> externalLinks;
    
    ArrayList<Document> documents;

    //Indicates true if crawler should parse text.
    boolean parseText;

    public CrawlerInstance(String startURL, String domain) throws IOException {
        this.startURL = startURL;
        visitedLinks = new HashSet<>();
        queue = new HashSet<>();
        externalLinks = new ArrayList<>();
        badURLs = new ArrayList<>();
        failedToDownloadUrls = new ArrayList<>();
        this.domainName = domain;
        this.documents = new FinalArrayList<>();
    }

    public void Start(boolean parseText) throws IOException {
        this.parseText = parseText;

        queue.add(startURL);

        while (!queue.isEmpty()) {
            processNextPage(queue.iterator().next());
        }
        
        for(Document d: documents){
            if(d.isFailedToDownload){
                totalNumberOfFailedToDownloadLinks++;
            }else{
                goodLinksCount++;
            }
            totalCountOfJSLinks += d.numberOfJSLinks;
        }
        
        System.out.println("\nNumber of correct links: " + goodLinksCount);

        System.out.println("\nNumber of word documents: " + numberOfWordDoc);
        System.out.println("Number of exel documents: " + numberOfExelDoc);
        System.out.println("Number of djvu documents: " + numberOfDjvuDoc);
        System.out.println("Number of pdf documents: " + numberOfPdf);
        System.out.println("Number of images: " + numberOfImages);
        System.out.println("Number of ppt and pptx docs: " + numberOfPowerPointDocs);
        System.out.println("Number of archieves: " + numberOfArchieves);

        System.out.println("\nNumber of javascript links: " + totalCountOfJSLinks);
        System.out.println("Other errors: " + totalNumberOfFailedToDownloadLinks);
        System.out.println("Bad exceptions " + numberOfExceptions);
    }

    private void processNextPage(String URL) {
        visitedLinks.add(URL);
        queue.remove(URL);

        try {
            if (URL.endsWith(".pdf")) {
                numberOfPdf++;
                return;
            }
            if (URL.endsWith(".doc") || URL.endsWith(".docx") || URL.endsWith(".rtf")) {
                numberOfWordDoc++;
                return;
            }
            if (URL.endsWith(".xls") || URL.endsWith(".xlsx")) {
                numberOfExelDoc++;
                return;
            }
            if (URL.endsWith(".ppt") || URL.endsWith(".pptx")) {
                numberOfPowerPointDocs++;
                return;
            }
            if (URL.endsWith(".zip") || URL.endsWith(".rar") || URL.endsWith(".gz")) {
                numberOfArchieves++;
                return;
            }
            if (URL.endsWith(".jpg") || URL.endsWith(".tif") || URL.endsWith(".gif")) {
                numberOfImages++;
                return;
            }
            if (URL.endsWith(".djvu")) {
                numberOfDjvuDoc++;
                return;
            }

            Document d = new ParserManager().Parse(URL, parseText);
            documents.add(d);
            
            System.out.println(documents.size() + " " + URL);

            for (String link : d.links) {
                if (isValid(link)) {
                    queue.add(link);
                }
            }
        } catch (Exception ex) {
            numberOfExceptions++;
            badURLs.add(URL);
        }
    }

    private boolean isValid(String URL) {
        if (!URL.contains(domainName)) {
            if (!externalLinks.contains(URL)) {
                externalLinks.add(URL);
            }
            return false;
        }
        return !(URL.contains("grafomann") || visitedLinks.contains(URL) || queue.contains(URL));
    }
}
