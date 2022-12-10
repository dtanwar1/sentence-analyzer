package mySentenceAnalyzer.myAnalyzer;

import java.util.HashMap;

public class CaseInsensetiveStrategy implements StrategyI {

    private String nameString = "CaseInsensetiveStrategy";
    
    @Override
    public String replaceWords(String[] listWords, HashMap<String, String> wordsLookUp) {
        String sentence= "";
        HashMap<String, String> wordslookup = new HashMap<String, String>();
        for(String s : wordsLookUp.keySet()){
            wordslookup.put(s.toLowerCase(), wordsLookUp.get(s).toLowerCase());
        }
        if(listWords!=null && listWords.length >0 && wordslookup!=null && wordslookup.size()>0){
            for (int i=0; i<= listWords.length -1;i++) {
                String word = listWords[i].toLowerCase();
                if(wordslookup.containsKey(word)){
                    listWords[i] = wordslookup.get(word);
                }
            }
            sentence = String.join(" ", listWords);
        }    
        return sentence;
    }

    @Override
    public String getName() {
        return nameString;
    }
}
