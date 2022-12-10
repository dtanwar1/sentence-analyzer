package mySentenceAnalyzer.util;



/**
 * Logger class that logs everything from errors, exceptions to display
 * output with the help of debug level enum
 * 
 * @author asatput1, Prof, TA
 */
public class MyLogger{

    public static enum DebugLevel {
        NONE, 
        DRIVER,
        FILE_PROCESSOR,
        RESULTS,
        SPELL_CHECK_AMERICAN,
        K_MOST_FREQUENT_WORDS,
        MY_ARRAYLIST;
        
    }

    private static DebugLevel debugLevel;

    public static DebugLevel getDebugLevel(){
        return debugLevel;
    }
    /**
     * sets the debug level to levelIn int
     * 
     * @param levelIn debugLevel in int form
     */
    public static void setDebugValue (int levelIn) {
        switch (levelIn) {
            case 1: debugLevel = DebugLevel.RESULTS; break;
            case 2: debugLevel = DebugLevel.FILE_PROCESSOR; break;
            case 3: debugLevel = DebugLevel.DRIVER; break;
            case 4: debugLevel = DebugLevel.SPELL_CHECK_AMERICAN; break;
            case 5: debugLevel = DebugLevel.K_MOST_FREQUENT_WORDS; break;
            case 6: debugLevel = DebugLevel.MY_ARRAYLIST; break;
            default: debugLevel = DebugLevel.NONE; break;
        }
    }

    /**
     * set the debugLevel for this session
     * 
     * @param levelIn debug level to set to
     */
    public static void setDebugValue (DebugLevel levelIn) {
	debugLevel = levelIn;
    }

    /**
     * display output based on the filter of debugLevel. all logs with
     * debugLevel <= levelIn will be displayed
     * 
     * @param message message to be printed
     * @param levelIn debug level threshold
     */
    public static void writeMessage (String     message  ,
                                     DebugLevel levelIn ) {
	if (debugLevel.compareTo(levelIn)>=0)
	    System.out.println(debugLevel+": "+Constants.NL+message);
    }

    /**
     * display error based on the filter of debugLevel. all logs with
     * debugLevel <= levelIn will be displayed
     * 
     * @param message message to be printed
     * @param levelIn debug level threshold
     */
    public static void writeError (String     message  ,
                                     DebugLevel levelIn ) {
	if (debugLevel.compareTo(levelIn)>=0 || levelIn.ordinal() >0)
	    System.err.println(message);
    }

    /**
     * method to return this object as a string
     * 
     * @return string form of this value which in this case gives
     * confirmation of selected debug level
     */
    public String toString() {
	return "The debug level has been set to the following " + debugLevel;
    }
}
