package mySentenceAnalyzer.myAnalyzer;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import mySentenceAnalyzer.util.FileProcessor;
import mySentenceAnalyzer.util.MyLogger;
import mySentenceAnalyzer.util.MyLogger.DebugLevel;

public class MyArrayList {

    private List<String> sentence;

    public  MyArrayList(){
        sentence = new ArrayList<String>();
    }
    
    public Iterator<String> getIterator(){
        return sentence.iterator();
    }

    public void accept(Visitor visitor){
        visitor.visit(this);
    }
    public void clear(){
        sentence.clear();
    }

    public void ReadFile(String fileName) throws Exception{
        FileProcessor fileProcessor = null;
        try {
            fileProcessor = new FileProcessor(fileName);
            if(fileProcessor!=null){
                String bToAString;
                while((bToAString =fileProcessor.readLine())!=null){
                   String replacedBtoA = bToAString.replace(".", " ");
                    sentence.add(replacedBtoA);
                }
                
            }           
        } catch (Exception ex) {
            MyLogger.writeError(ex.toString(),DebugLevel.MY_ARRAYLIST );
            System.exit(0);     
        }
        finally{
            if(fileProcessor!=null)
                fileProcessor.close();
        }               
    }
    
}
