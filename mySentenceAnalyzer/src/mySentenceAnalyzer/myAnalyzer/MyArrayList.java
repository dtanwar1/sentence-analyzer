package mySentenceAnalyzer.myAnalyzer;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import mySentenceAnalyzer.util.FileProcessor;

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

    public void ReadFile(String fileName){
        FileProcessor fileProcessor = null;
        try {
            fileProcessor = new FileProcessor(fileName);
            if(fileProcessor!=null){
                String bToAString;
                while((bToAString =fileProcessor.readLine())!=null){
                    String[] bToAWordsArray = bToAString.split(".");
                    sentence.add(bToAString);
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
