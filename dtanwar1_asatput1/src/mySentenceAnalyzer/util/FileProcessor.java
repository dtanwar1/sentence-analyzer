package mySentenceAnalyzer.util;

import java.io.BufferedReader;
import java.io.FileReader;

public class FileProcessor {

    private BufferedReader reader;
    private FileReader fileReader;

    public FileProcessor(String fileName) throws Exception  {

        try {
            fileReader = new FileReader(fileName);
            reader = new BufferedReader(fileReader);                
        } catch (Exception ex) {     
            System.err.println("File Not found at File Processor");        
            throw ex;     
        }

    }

    /** 
     * This function reads a line from file and returns String.
     * @return  A line that is being read.
    */
    public String readLine() {
        String line = null;
        if (reader != null) {
            try {
                line = reader.readLine();
            } catch (Exception ex) {      
                System.err.println("Error occured while reading file");            
                ex.printStackTrace();
            }
        }
        return line;
    }
    /** 
     * This function closes the file.
    */
    public void close() {

        try {
            if (reader != null)
                reader.close();
            if (fileReader != null)
                fileReader.close();
        } catch (Exception ex) {
            System.err.println("Error occured while closing file");    
            ex.printStackTrace();

        } finally {
            reader = null;
            fileReader = null;
        }

    }
    public String  toString(){
        return "";
    }
}

