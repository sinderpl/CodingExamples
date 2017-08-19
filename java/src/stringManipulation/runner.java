package stringManipulation;

/**
 * 
 * @author Alan Niemiec
 * 
 * Runner for the stringManipulator
 *
 */
public class runner {
	
	private static String testString = "I am currently interviewing at your company. ";

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		stringManipulator manipulator = new stringManipulator();
		manipulator.countAverageLetters(testString);
		manipulator.reverse(testString);
		manipulator.reverseWords(testString);
		
		manipulator.isPalindrome("radar");
		manipulator.isPalindrome("cup");

	}

}
