package parser;

import org.jsoup.nodes.Attribute;
import org.jsoup.nodes.Attributes;
import org.jsoup.nodes.Element;
import org.jsoup.parser.Tag;

public class Normalizator {
    public static String NormalizeLink(String parentURL, String childURL){
        Attributes attribs = new Attributes();
        Tag t = Tag.valueOf("a");
        attribs.put(new Attribute("href", childURL));
        Element link = new Element(t, parentURL, attribs);
        return link.absUrl("href");
    }
}
