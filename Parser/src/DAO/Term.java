package DAO;

public class Term {
    
    private String stem;
    private int df;

    public Term() {
        stem = "";
        df = -1;
    }
    
    public Term(Term term) {
        this.stem = term.getStem();
        this.df = term.getDf();
    }
    
    public Term(String stem, int df) {
        this.stem = stem;
        this.df = df;
    }
    
    public String getStem() {
        return stem;
    }

    public void setStem(String stem) {
        this.stem = stem;
    }

    public int getDf() {
        return df;
    }

    public void setDf(int df) {
        this.df = df;
    }
    
}
