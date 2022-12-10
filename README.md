# CSX42: Assignment 4
## Name: Deepak Tanwar
## Name: Abhishek Satpute
-----------------------------------------------------------------------
-----------------------------------------------------------------------
#### Note : Make sure you're in this directory cs542-fall-22-assign4-team-dtanwar1_asatput1 before running below commands

Following are the commands and the instructions to run ANT on your project.
#### Note: build.xml is present in mySentenceAnalyzer/src folder.

#### Note : Please give inputs in following order:-
#### 1. Input File with Sentences
#### 2. Input File with English American Spellings
#### 3. K value
#### 4. K most frequent word output
#### 5. English to American output
#### 6. Log Level


-----------------------------------------------------------------------
## Instruction to clean:

####Command: ant -buildfile mySentenceAnalyzer/src/build.xml clean

Description: It cleans up all the .class files that were generated when you
compiled your code.

-----------------------------------------------------------------------
## Instruction to compile:

####Command: ant -buildfile mySentenceAnalyzer/src/build.xml all

Description: Compiles your code and generates .class files inside the BUILD folder.

-----------------------------------------------------------------------
## Instruction to run:

####Command: ant -buildfile mySentenceAnalyzer/src/build.xml run -Darg0=SentencesInput.txt -Darg1=BtoASpelling.txt -Darg2=5 -Darg3=KMostOutput.txt -Darg4=BTOAOutput.txt -Darg5=6


-----------------------------------------------------------------------
## Description:

INPUT FILES :--->SentencesInput.txt,BtoASpelling.txt
OUTPUT FILES :--->KMostOutput.txt,BTOAOutput.txt
Code Structure:->

This project consists of 4 Packages:

1. Driver - To execute the code.
2. Utils - Contains all the utility classes needed for this project.
3. myAnalyzer - Contains visitor, strategy interface and implementation.



Basic Flow and Time Complexity:->

A)DESIGN PATTERN:-> We will be using  visitor and strategy pattern together. Here SpellCheckAmerican and KMostFrequent class are visitors.  CaseInsensetiveStrategy and CaseSensetiveStrategy class is implementation of strategy interface.

B) Driver code performs following tasks in order:->

    Create Instance of the MyArrayList, Strategies and Visitors. 
    Accept method on my arraylist is called with different implementaion of visitors.
    The accept method delegates the call to visit method.
    This in turn calls the read file method performs logic and writes to ouput.

C) Time Complexity: For K Most from priority queue O(KlogN)
                    For Replacing Words O(N)

	


SLACK DAY - 1 day
-----------------------------------------------------------------------
### Academic Honesty statement:
-----------------------------------------------------------------------

"I have done this assignment completely on my own. I have not copied
it, nor have I given my solution to anyone else. I understand that if
I am involved in plagiarism or cheating I will have to sign an
official form that I have cheated and that this form will be stored in
my official university record. I also understand that I will receive a
grade of 0 for the involved assignment for my first offense and that I
will receive a grade of F for the course for any additional
offense.""

Date: -- 9th December  2022

