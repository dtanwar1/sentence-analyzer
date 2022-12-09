package mySentenceAnalyzer.myAnalyzer;

public interface Visitor {
    public void visit(MyArrayList  myElement);    
    public void setStrategy(StrategyI  myStrategy);      
}
