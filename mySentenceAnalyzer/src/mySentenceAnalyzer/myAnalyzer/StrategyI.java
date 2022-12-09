package mySentenceAnalyzer.myAnalyzer;

import java.util.HashMap;

public interface StrategyI {
    public String replaceWords(String[] listWords, HashMap<String,String> wordsLookUp);    
}
