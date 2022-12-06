package mySentenceAnalyzer.util;

/**
 * This class holds constants required by other classes.
 * these constants are static and final so they can only be accessed
 * but can't be changed by other classes.
 * for now, only new line constant is added as new line character is
 * different for different operating systems
 * 
 * @author: asatput1
 */

public class Constants {
    public static final String NL = "\r\n";                                         // for Windows
    // public static final String NL = "\n";                                           // for UNIX
  
  

    /**
     * returns an empty string. can be accessed by all classes
     * 
     * @return returns an empty string
     */
    public String toString(){
        return "";
    }
}
