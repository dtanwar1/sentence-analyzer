package myCampusTour.util;

import myCampusTour.util.MyLogger.DebugLevel;

/**
 * This class handles all errors. when an exception is thrown by any 
 * method in other classes, it is passed to this class. the methods of 
 * this class write the error to an error string which can be written
 * to an errorLog.txt file by the driver code. these exceptions are also
 * displayed with their respective StackTraces. Errors occured when 
 * trying to assign courses with no seats available are also logged here
 * 
 * datamember errsb is an error string builder which needs to be 
 * accessed from other classes but should not be created as a new object
 * when the class is instantiated everytime. so, it is declared as
 * private static and is accompanied with an public accessor function
 * getErrors
 * 
 * uses MyLogger to log errors
 * 
 * @see StringBuilder
 * @see Exception
 * @see StackTraceElement
 * 
 * @see MyLogger
 * @see Constants
 * 
 * @author: asatput1
 */

public class ErrorWriter {
    private static StringBuilder errsb;

    public ErrorWriter(){
        errsb = new StringBuilder();
    }

    /**
     * displays the exception in system.err with the stacktrace, also
     * logs the the exception in errorstring using the string builder
     * errsb. which can be accessed by all classes. this method can
     * be called by all classes
     * 
     * @param e exception passed to the method
     */
    public void exceptionWrite(Exception e, String errMsg, DebugLevel dl){
        StringBuilder errTemp = new StringBuilder();
        errTemp.append(e.toString()+Constants.NL);
        for(StackTraceElement ee:e.getStackTrace()){
            errTemp.append("\t"+ee+Constants.NL);
        }
        errsb.append(errTemp.toString()+Constants.NL);
        if((!errMsg.equals(""))&&(errMsg!=null))
            errsb.append(errMsg+Constants.NL);
        MyLogger.writeError("Error occured: "+errTemp.toString()
        +Constants.NL+"TL;DR : "+errMsg+Constants.NL,dl);
    }

    /**
     * appends the error message to the error string using string 
     * builder errsb. this method can be called by all classes
     * 
     * @param errIn error message passed to this method
     */
    public void errorWrite(String errIn){
        errsb.append(errIn+Constants.NL);
    }

    /**
     * accessor function for StringBuilder errsb. once all errors and
     * exceptions are written to errsb, this function returns the string
     * from errsb using toString method. which can be used by the driver
     * code to write errors to errorLog.txt
     * this method can be called by all classes
     * 
     * @param e exception passed to the method
     * @return error string from the errsb string builder
     */
    public String getErrors(){
        return errsb.toString();
    }

    /**
     * returns an empty string. can be accessed by all classes
     * 
     * @return returns an empty string
     */
    public String toString(){
        return "";
    }
}
