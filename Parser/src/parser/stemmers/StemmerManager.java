package parser.stemmers;

public class StemmerManager {
    private IStemmer stemmer;
    public StemmerManager(IStemmer stemmer){
        this.stemmer = stemmer;
    }
    
    public String getStem(String word){
        return stemmer.stem(word);
    }
}
