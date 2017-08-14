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
	 * Counts the average amount of letters per word in a string
	 * It does not use anything like split() to find the words
	 * @param String word - The string sentence to be split and counted
	 */
	public void countAverageLetters(String sentence){
		
		//Split the string up into words
		ArrayList<String> wordArray=  split(sentence);
		
		//Counter variables
		int wordCount = wordArray.size();
		int letterCount = 0;
		
		//Calculates the letters in each word
		for (String word : wordArray){
			//Adds the total letters in the word to the total
			letterCount += word.length();
		}
		
		//Print out the word and letter count
		System.out.printf("WordCount: %d , LetterCount: %d \n", wordCount, letterCount);
		//Calculate the average amount of letter per word
		float average = (float) letterCount/wordCount;
		//Print the average
		System.out.printf("Average letter count per word: %d / %d = %.2f", letterCount, wordCount, average);
	}
	
	/**
	 * 
	 * Splits the input string into individual words without using the java string split method
	 * 
	 * @param string
	 * @return A String array with the individual words split from input string
	 */
	public ArrayList<String> split(String string){
		//Variables
		ArrayList<String> stringArray = new ArrayList<String>();
		boolean isCurrentWord = false;
		String currentWord = "";
		
		//Convert the string to a char array to allow for finding alphabet characters
		char[] charArray = string.toCharArray();
		
		/**
		 * Iterate through each character picking out individual words
		 * when hitting anything that is not a alphabetic character
		 */
		for(int x=0; x<string.length(); x++){
			//Checks if the char is a letter
			if(Character.isLetter(charArray[x])){
				//Start the creation of a word
				isCurrentWord = true;
				//Add the character 
				currentWord += charArray[x];
			}else{
				//The word was finished so we set the current word flag to false
				isCurrentWord = false;
				//Adds the currentWord to the word array if it 
				if(currentWord != ""){
					stringArray.add(currentWord);
				// Set the currentWord to empty again
					currentWord = "";
				} //End if
			}//End else
		} //End For loop
		
		/**
		 * Do one final check as the code can omit final words in some cases
		 * This happens if the final word has no following character or empty space
		 */
		if(isCurrentWord && currentWord != ""){
			stringArray.add(currentWord);
				currentWord = "";
			}// End if
		//Return the output
		return stringArray;
	}//End Method


}//End class
