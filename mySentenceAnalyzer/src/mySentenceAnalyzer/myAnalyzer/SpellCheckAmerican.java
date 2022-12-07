package mySentenceAnalyzer.myAnalyzer;

import java.util.HashMap;
import java.util.Iterator;

import mySentenceAnalyzer.util.FileProcessor;

public class SpellCheckAmerican implements Visitor {
    private  static String whiteSpaceCharacter = " ";
    private  HashMap<String,String> wordsLookUp;
    private String lookUpFileName;

    public SpellCheckAmerican(String fileName){
        lookUpFileName = fileName;
        wordsLookUp = new HashMap<String,String>();
    }

    @Override
    public void visit(MyArrayList myElement) {
        try {
            Iterator<String> myListIterator = myElement.getIterator();
            if(myListIterator!=null){
                getBritishToAmericanLookUp();
                if(wordsLookUp!=null && wordsLookUp.size()>0){

                    while(myListIterator.hasNext()){

                        String[] listWords = getWordsList(myListIterator.next());

                    
                    }
                }
            }
        } catch (Exception e) {
            
        }
        finally{
            wordsLookUp.clear();
        }
       

       
        
        
    }

    private String[] getWordsList(String sentence){
        String[] listWords= null;
        try {
            listWords = sentence.split(whiteSpaceCharacter);
        } catch (Exception e) {
            
        }
        return listWords;
    }

    private void getBritishToAmericanLookUp(){
        FileProcessor fileProcessor = null;
        try {
            fileProcessor = new FileProcessor(lookUpFileName);
            if(fileProcessor!=null){
                String bToAString;
                while((bToAString =fileProcessor.readLine())!=null){
                    String[] bToAWordsArray = bToAString.split(":");
                    wordsLookUp.put(bToAWordsArray[0], bToAWordsArray[1]);

                }
                
            }           
        } catch (Exception e) {
            
        }
        finally{
            if(fileProcessor!=null)
                fileProcessor.close();
        }               
    }




    
    


    
}
