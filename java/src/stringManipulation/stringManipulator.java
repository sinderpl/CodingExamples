package stringManipulation;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * 
 * @author Alan Niemiec
 *
 * A class allowing for manipulating and evaluating strings
 */

public class stringManipulator {
	
	
	/**
	 * Counts the average amount of letter per word in a string
	 * It does not use anything like split() to find the words
	 * @param String word - The string sentence to be split and counted
	 */
	public void countAverageLetters(String word){
		
		//Counts the 
		int wordCount = 0;
		int letterCount = 0;
		
		//Making sure we are currently iterating through a word
		boolean isCurrentWord = false;
		
		//Array list for words, not needed, just kept for reference
		ArrayList<String> wordArray = new ArrayList<String>();
		
		//Keeps tabs on current word
		String currentWord = "";
		
		//Convert the word string to a char array
		char[] charArray = word.toCharArray();
		
		
		//Iterates over every character in the 
		for(int x=0; x<word.length(); x++){
			
			if(charArray[x] != ' '){
				isCurrentWord = true;
				currentWord += charArray[x];
				letterCount ++;
			}else{
				isCurrentWord = false;
				if (currentWord != ""){
					wordCount += 1;
					wordArray.add(currentWord);
					currentWord = "";
				}
			}
		}
		
		//One final addition is needed because the for loop cuts out before the final
		// iteration is completed
		if(isCurrentWord && currentWord != ""){
			wordCount += 1;
			wordArray.add(currentWord);
			currentWord = "";
		}
		
		//Print out the word and letter count
		System.out.printf("WordCount: %d , LetterCount: %d \n", wordCount, letterCount);
		//Calculate the average amount of letter per word
		float average = (float) letterCount/wordCount;
		System.out.printf("Average letter count per word: %d / %d = %.2f", letterCount, wordCount, average);
	}
	
	

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		stringManipulator manipulator = new stringManipulator();
		
		manipulator.countAverageLetters(" I am currently interviewing at SAP ");
		

	}

}
