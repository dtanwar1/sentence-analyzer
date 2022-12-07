package mySentenceAnalyzer.myAnalyzer;

import java.util.HashMap;

public interface StrategyI {
    public void replaceWords(String[] listWords, HashMap<String,String> wordsLookUp);    
}
