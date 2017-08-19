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
	 * @return A float value representing the average amount of letters in a word
	 */
	public float countAverageLetters(String sentence){
		
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
		//System.out.printf("WordCount: %d , LetterCount: %d \n", wordCount, letterCount);
		//Calculate the average amount of letter per word
		float average = (float) letterCount/wordCount;
		//Print the average
		//System.out.printf("Average letter count per word: %d / %d = %.2f \n", letterCount, wordCount, average);
		
		//Return the output
		return average;
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
	
	/**
	 * 
	 * @param string string to be reversed
	 * @return A reverse String value is returned
	 */
	public String reverse(String string){
		//Reversed string
		String reverse = "";
		//Iterate through each character in the string
		for(int x = string.length()-1; x >= 0; x--){
			reverse += string.charAt(x);
		}
		//Print out the results
		//System.out.printf("Original: %s | Reversed: %s \n", string, reverse );
		//Returns the reversed string
		return reverse;
	}//End of method
	
	/**
	 * 
	 * Returns the original string with the word placement reversed
	 * 
	 * @param string the input string in which we want the words to be reversed
	 * @return A string with the words in the sentence reversed
	 */
	public String reverseWords(String string){
		//Output string
		String result = "";
		
		//Split the words into an array using the spit method
		ArrayList<String> splitWords = split(string);
		
		//Reverse the words in the sentence
		for(String word : splitWords){
			//Add the words to the output working your way backwards
			result += " "+word;
		}
		
		//Output visual result
		//System.out.printf("Original: %s | Reversed words: %s \n" , string, result);
		
		//Return the output
		return result;
	}

	/**
	 *  Checks whether a string is a palindrome, eg radar = true, cup = false
	 *  The word has to be the same when reversed
	 * @param string The input string to be verified whether it is a palindrome
	 * @return A boolean value representing whether the input is a palindrome
	 */
	public boolean isPalindrome(String string){
		//Output string
		boolean result;
		
		//Reverse the string
		String reversed = reverse(string);
		
		//Check whether the reverse string is equal to original
		if(string.equals(reversed))
			result = true;
		else
			result = false;
		
		//System.out.printf("Is %s a palindrome : %b \n" , string, result);
		
		//Return the result
		return result;
	}

}//End class
