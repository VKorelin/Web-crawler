package parser;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class HtmlParser implements IParser{

    String webAddress;
    String text;
    boolean parseText;
    public boolean isFailedToDownload;
    public ArrayList<String> linksList;
    Document doc;
    public int numberOfLinksExtractionErrors = 0;
    public int javaScriptLinks = 0;
    
    public HtmlParser(String webAddr, boolean parseText){
        this.webAddress = webAddr;
        this.parseText = parseText;
        this.linksList = new ArrayList<>();
    }

    public void parse() {
        try {
            doc = Jsoup.connect(webAddress).get();
            text = getElements(doc);
            isFailedToDownload = false;
        } catch (IOException e) {
            System.out.println("\nERROR in URL downloading! (" + webAddress + ")\n");
            isFailedToDownload = true;
        }
    }

    public void parse(File f) {
        if (f == null) {
            return;
        }
        
        try {
            doc = Jsoup.parse(f, "utf-8");
            text = getElements(doc);
        } catch (IOException e) {
            isFailedToDownload = true;
        }
    }

    private String getElements(Document doc) {
        String text = "";
        if (parseText) {
            Elements elements = doc.body().select("*");
            for (Element element : elements) {
                text = text + " " + element.ownText();
            }
        }
        
        linksList =findURL(doc);
        
        return text;
    }
    
    public ArrayList<String> findURL(Document d) /*throws IOException, URISyntaxException*/ {
        ArrayList<String> resultLinks = new ArrayList<>();
        String htmlText = d.outerHtml().toLowerCase().replaceAll("\\s+","");
        
        int idx = 0;

        while (idx < htmlText.length() && htmlText.indexOf("href", idx) != -1) {
            idx = htmlText.indexOf("href", idx) + 4;

            if (htmlText.charAt(idx) != ' ' && htmlText.charAt(idx) != '=' && htmlText.charAt(idx) != '"') {
                continue;
            }

            int startIdx = -1;
            int finishIdx = -1;

            int i = 0;
            try {
                while (i < 2) {
                    if (idx >= htmlText.length()) {
                        break;
                    }
                    if (htmlText.charAt(idx) == '"' && i == 0) {
                        startIdx = idx + 1;
                        i++;
                    } else {
                        if (htmlText.charAt(idx) == '"' && i == 1) {
                            finishIdx = idx;
                            i++;
                        }
                    }
                    idx++;
                }
            } catch (Exception ex) {
                numberOfLinksExtractionErrors++;
                continue;
            }
            if (startIdx == -1 || finishIdx == -1) {
                continue;
            }

            String extractedUrl = htmlText.substring(startIdx, finishIdx);

            if (extractedUrl.startsWith("javascript:")) {
                javaScriptLinks++;
                continue;
            }

            resultLinks.add(Normalizator.NormalizeLink(webAddress, extractedUrl));
            
        }
        return resultLinks;
    }
}
