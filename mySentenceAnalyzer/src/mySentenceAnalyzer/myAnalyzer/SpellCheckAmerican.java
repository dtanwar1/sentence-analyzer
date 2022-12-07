package mySentenceAnalyzer.myAnalyzer;

import java.util.HashMap;
import java.util.Iterator;

import mySentenceAnalyzer.util.FileDisplayInterface;
import mySentenceAnalyzer.util.FileProcessor;
import mySentenceAnalyzer.util.Results;

public class SpellCheckAmerican implements Visitor {
    private  static String whiteSpaceCharacter = " ";
    private  HashMap<String,String> wordsLookUp;
    
    private String inputFileName;
    private String outputFileName;
    private String bToAFileName;
    private StrategyI strategyImpl;

    public SpellCheckAmerican(String inputFileNameIn,
                              String bToAFileNameIn,
                              String outputFileNameIn,
                              StrategyI strategyImplIn){
        inputFileName = inputFileNameIn;
        wordsLookUp = new HashMap<String,String>();
        bToAFileName = bToAFileNameIn;
        strategyImpl = strategyImplIn;
        outputFileName = outputFileNameIn;
    }

    @Override
    public void visit(MyArrayList myElement) {
        try {
            myElement.ReadFile(inputFileName);
            Iterator<String> myListIterator = myElement.getIterator();
            if(myListIterator!=null){
                getBritishToAmericanLookUp();
                if(wordsLookUp!=null && wordsLookUp.size()>0){

                    while(myListIterator.hasNext()){
                        String[] listWords = getWordsList(myListIterator.next());
                        strategyImpl.replaceWords(listWords,wordsLookUp);                    
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
            fileProcessor = new FileProcessor(bToAFileName);
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

    private void writeOutput(){
        FileDisplayInterface fileWrite = null;
        try{
            fileWrite = new Results();
            fileWrite.writeResults("", outputFileName);
        }
        catch(Exception ex){

        }

    }




    
    


    
}
