package mySentenceAnalyzer.myAnalyzer;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

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
    
}
