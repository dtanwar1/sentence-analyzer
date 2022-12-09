package mySentenceAnalyzer.myAnalyzer;

import java.util.HashMap;

public class CaseSensitiveStrategy implements StrategyI {

  

    @Override
    public String replaceWords(String[] listWords, HashMap<String, String> wordsLookUp) {
        String sentence="";
        if(listWords!=null && listWords.length >0
            && wordsLookUp!=null && wordsLookUp.size()>0){

                for (int i=0; i<= listWords.length -1;i++) {

                    if(wordsLookUp.containsKey(listWords[i])){
                        listWords[i] = wordsLookUp.get(listWords[i]);
                    }                    
                }

                sentence = String.join(" ", listWords);
        }        
        return sentence;
    }
    
}
