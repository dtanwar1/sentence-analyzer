package mySentenceAnalyzer.myAnalyzer;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Map.Entry;



public class KMostFrequentWords implements Visitor {

    private int topK;
    private String inputFileName;
    private String outputFileName;
    private  static String whiteSpaceCharacter = " ";
    private HashMap<String,Integer> wordsDict;
    private PriorityQueue<Entry<String,Integer>> priorityQueue;
    private StringBuilder outpStringBuilder;
    
    

    public KMostFrequentWords(int topKin,
                            String inputFileNameIn,
                            String outputFileNameIn){
        topK = topKin;
        inputFileName = inputFileNameIn;
        outputFileName = outputFileNameIn;
        
        wordsDict = new HashMap<String,Integer>();
        outpStringBuilder = new StringBuilder();
        
    }

    @Override
    public void visit(MyArrayList  myElement) {
        try{
            myElement.ReadFile(inputFileName);
            Iterator<String> myListIterator = myElement.getIterator();
            while(myListIterator.hasNext()){
                String[] listWords = getWordsList(myListIterator.next());
                addToWordsDictionary(listWords);
            }
            addToPriorityQueue();
            getTopKWords();
            writeOutput();
        }
        catch(Exception ex){

        }    
        finally{
            wordsDict.clear();
            priorityQueue.clear();
            outpStringBuilder = null;
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

    private void getTopKWords(){
        if(priorityQueue!=null){
            outpStringBuilder.append("KMostFrequentWords  :  Count").append("\n");
            while(priorityQueue.size() > 0 || topK > 0){
                Entry<String,Integer> entry = priorityQueue.poll();
                entry.getKey();
                outpStringBuilder.append(entry.getKey()+"  :  "+entry.getValue()).append("\n");
                topK--;
            }            
        }
    }

    private void addToWordsDictionary(String[] listWords){
        if(listWords!=null && listWords.length > 0){     
            for (String words : listWords) {
                if(!wordsDict.containsKey(words)){
                    wordsDict.put(words, 1);
                }
                else{
                    int count =wordsDict.get(words);
                    count = count+1;
                } 
            }        
        }
    }
    private void addToPriorityQueue(){        
        if(wordsDict!=null && wordsDict.size() > 0){
            if(priorityQueue == null){ 
                Comparator objComparator = Entry.comparingByValue().reversed();
                priorityQueue = new PriorityQueue<Entry<String,Integer>>(wordsDict.size(),objComparator);
            }
            for (Entry<String,Integer> entry : wordsDict.entrySet()) {
                priorityQueue.add(entry);
            }
        }
    }
    private void writeOutput(){

    }

    
    
}
