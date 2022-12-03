package mySentenceAnalyzer.myAnalyzer;

import java.util.Iterator;
import java.util.List;

public class SpellCheckAmerican implements Visitor {


    @Override
    public void visit(MyArrayList myElement) {
        Iterator<String> myListIterator = myElement.getIterator();

        while(myListIterator.hasNext()){
            
        }
        
        
    }
    
}
