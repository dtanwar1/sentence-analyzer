package mySentenceAnalyzer.myAnalyzer;

import java.util.HashMap;
import java.util.Iterator;

import mySentenceAnalyzer.util.Constants;
import mySentenceAnalyzer.util.FileDisplayInterface;
import mySentenceAnalyzer.util.FileProcessor;
import mySentenceAnalyzer.util.MyLogger;
import mySentenceAnalyzer.util.Results;
import mySentenceAnalyzer.util.MyLogger.DebugLevel;

public class SpellCheckAmerican implements Visitor {
    private  static String whiteSpaceCharacter = " ";
    private  HashMap<String,String> wordsLookUp;
    
    private String inputFileName;
    private String outputFileName;
    private String bToAFileName;
    private StrategyI strategyImpl;
    private StringBuilder outpBuilder;

    public SpellCheckAmerican(String inputFileNameIn,
                              String bToAFileNameIn,
                              String outputFileNameIn){
        inputFileName = inputFileNameIn;
        wordsLookUp = new HashMap<String,String>();
        bToAFileName = bToAFileNameIn;
        outputFileName = outputFileNameIn;
        outpBuilder = new StringBuilder();
    }

    @Override
    public void visit(MyArrayList myElement) {
        try {
            myElement.ReadFile(inputFileName);                    
            Iterator<String> myListIterator = myElement.getIterator();
            getBritishToAmericanLookUp();
            ConvertFromBritishToAmerican(myListIterator,strategyImpl);
            
        } catch (Exception ex) {
            MyLogger.writeError(ex.toString(),DebugLevel.SPELL_CHECK_AMERICAN );   
        }
        finally{
            wordsLookUp.clear();
            myElement.clear();
        }                          
    }

    

    private void ConvertFromBritishToAmerican(Iterator<String> myListIterator, StrategyI strategyImpl) {
        if(myListIterator!=null){
            

            if(wordsLookUp!=null && wordsLookUp.size()>0){
                outpBuilder.append(Constants.NL).append(strategyImpl.getName() + ":").append(Constants.NL).append(Constants.NL);
                while(myListIterator.hasNext()){

                    String[] listWords = getWordsList(myListIterator.next());
                    String replacedSentence = strategyImpl.replaceWords(listWords,wordsLookUp);     
                    outpBuilder.append(replacedSentence).append(".").append(Constants.NL);                
                }
                writeOutput();
            }
        }
    }

    private String[] getWordsList(String sentence){
        String[] listWords= null;
        try {
            listWords = sentence.split(whiteSpaceCharacter);
        } catch (Exception ex) {
            MyLogger.writeError(ex.toString(),DebugLevel.SPELL_CHECK_AMERICAN );   
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
                    String replacedBtoA = bToAWordsArray[1].replace(".", " ");
                    wordsLookUp.put(bToAWordsArray[0], replacedBtoA);

                }
                
            }           
        } catch (Exception ex) {
            MyLogger.writeError(ex.toString(),DebugLevel.SPELL_CHECK_AMERICAN );   
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
            fileWrite.writeResults(outpBuilder.toString(), outputFileName);
        }
        catch(Exception ex){
            MyLogger.writeError(ex.toString(),DebugLevel.SPELL_CHECK_AMERICAN ); 
        }

    }
    @Override
    public void setStrategy(StrategyI strategyIn) {
        strategyImpl = strategyIn;           
    }




    
    


    
}
