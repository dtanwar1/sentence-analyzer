package myCampusTour.util;

import java.io.FileWriter;
import java.io.IOException;
import java.io.File;
import myCampusTour.util.MyLogger.DebugLevel;

/**
 * this class is used to display output to output stream and write 
 * the output to a file. Implements 2 interfaces.
 * 
 * @see FileWriter
 * @see IOException
 * @see File
 * @see StringBuilder
 * 
 * @see FileDisplayInterface
 * @see StdoutDisplayInterface
 * @see ErrorWriter
 * 
 * @author: asatput1
 */

public class Results implements FileDisplayInterface, StdoutDisplayInterface {
    private ErrorWriter err = new ErrorWriter();
    final DebugLevel dl = DebugLevel.RESULTS;

    /**
     * This method writes string resultIn to a file with path toPath
     * if the file does not exist, it creates the file. if the 
     * directories don't exist. it gives an IOExecption. this method can
     * be called by all classes
     * 
     * @param resultIn string that has to be written to the file
     * @param toPath path of the file
     */
    @Override
	public void writeResults(String resultIn,String toPath){
        FileWriter outFile = null;
        try {
            StringBuilder sb = new StringBuilder();
            File f = new File(toPath);
            if(!f.exists()){
                f.createNewFile();
            }
            sb.append(resultIn);

            outFile = new FileWriter(toPath);
            outFile.write(sb.toString());

            outFile.close();
        } catch (IOException e) {
            err.exceptionWrite(e,"Error while closing the file outFile",dl);
        } finally {
            try {
                outFile.close();
            } catch (IOException e) {
                err.exceptionWrite(e,"Error while closing the file outFile",dl);
            }
        }
    }

    /**
     * This method displays string resultIn to the output stream this 
     * method can be called by all classes
     * 
     * @param resultIn string that has to be displayed on output stream
     */
    @Override
    public void displayResults(String resultIn){
        System.out.println(resultIn);
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
