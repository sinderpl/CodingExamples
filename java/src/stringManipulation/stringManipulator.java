package stringManipulation;

import java.util.ArrayList;

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
	 */
	public void countAverageLetters(String word){
		
		//Counts the 
		int wordCount = 0;
		int letterCount = 0;
		
		//Making sure we are currently iterating through a word
		boolean isCurrentWord = false;
		
		//Array list for words
		ArrayList<String> wordArray = new ArrayList<String>();
		
		//Keeps tabs on current word
		String currentWord = "";
		
		for (char n : word.toCharArray()){
			
			if (n != ' '){
				currentWord += n;
				letterCount += 1;
			}else{
				isCurrentWord = false;
				wordCount += 1;
				wordArray.add(currentWord);
				currentWord = "";
			}
			
			/**
			if(isCurrentWord){
				if (n != ' '){
					currentWord += n;
					letterCount += 1;
				}else{
					isCurrentWord = false;
					wordCount += 1;
					wordArray.add(currentWord);
					currentWord = "";
				}
			}else {
				if(n == ' '){
					isCurrentWord = true;
				}**/
			
		}
		
		System.out.println(wordArray);
		
		
		System.out.printf("wordCount: %d , letterCount: %d \n", wordCount, letterCount);
		
		float average = (float) letterCount/wordCount;
		System.out.printf("Average letter count per word: %.2f", average);
	}
	
	

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		stringManipulator manipulator = new stringManipulator();
		
		manipulator.countAverageLetters(" I am currently interviewing at SAP");
		

	}

}
