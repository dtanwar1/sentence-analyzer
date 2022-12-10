package mySentenceAnalyzer.driver;

import mySentenceAnalyzer.myAnalyzer.CaseInsensetiveStrategy;
import mySentenceAnalyzer.myAnalyzer.CaseSensitiveStrategy;
import mySentenceAnalyzer.myAnalyzer.KMostFrequentWords;
import mySentenceAnalyzer.myAnalyzer.MyArrayList;
import mySentenceAnalyzer.myAnalyzer.SpellCheckAmerican;
import mySentenceAnalyzer.myAnalyzer.StrategyI;
import mySentenceAnalyzer.myAnalyzer.Visitor;
import mySentenceAnalyzer.util.MyLogger;
import mySentenceAnalyzer.util.MyLogger.DebugLevel;

/**
 * @author placeholder
 *
 */
public class Driver {
	public static void main(String[] args) {

		/*
		 * As the build.xml specifies the arguments as argX, in case the
		 * argument value is not given java takes the default value specified in
		 * build.xml. To avoid that, below condition is used
		 */

		if (args.length != 6 || args[0].equals("${arg0}") || args[1].equals("${arg1}") || args[2].equals("${arg2}")
			|| args[3].equals("${arg3}") || args[4].equals("${arg4}") || args[5].equals("${arg5}")) {

				System.err.println("Error: Incorrect number of arguments. Program accepts 6 argumnets.");
				System.exit(0);
		}
	

		try {
								
				
			int loglevel = Integer.parseInt(args[5]);
			MyLogger.setDebugValue(loglevel);	

			String inputFileScentences = args[0];
			String inputFileBToA = args[1];
			int topK = Integer.parseInt(args[2]);
			String outputFileKMost = args[3];
			String outputFileSpellCheck = args[4];
									
			MyArrayList myArrayListObj = new MyArrayList();	
			
			Visitor kFrequentWordsVisitor = new KMostFrequentWords(topK,inputFileScentences,outputFileKMost);
			myArrayListObj.accept(kFrequentWordsVisitor);
			
			StrategyI caseSenStrategy = new CaseSensitiveStrategy();
			StrategyI caseInSenStrategy = new CaseInsensetiveStrategy();
			
			Visitor spellCheckVisitor = new SpellCheckAmerican(inputFileScentences,inputFileBToA,outputFileSpellCheck);	

			spellCheckVisitor.setStrategy(caseInSenStrategy);
			myArrayListObj.accept(spellCheckVisitor);
			
			spellCheckVisitor.setStrategy(caseSenStrategy);
			myArrayListObj.accept(spellCheckVisitor);


			
		} catch (Exception ex) {
			if(MyLogger.getDebugLevel() == null) MyLogger.setDebugValue(1);		
			MyLogger.writeError(ex.toString(),DebugLevel.DRIVER ); 
			System.exit(0);
		}
		
		
								 												
	}
}