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
		
		long startTime1 = System.nanoTime();
		//My method
		manipulator.reverse("trouble");
		long endTime1 = System.nanoTime();
		
		
		long startTime2 = System.nanoTime();
		//String builder
		manipulator.reverseBuilder("trouble");
		long endTime2 = System.nanoTime();
		
		long execTime1 = endTime1 - startTime1;
		long execTime2 = endTime2 - startTime2;
		
		System.out.printf("For loop time: %d%n   || StringBuilder time: %d%n \n" , execTime1, execTime2);
		if(execTime1 < execTime2){
			System.out.println("For Loop wins");
		}else{
			System.out.println("String builder wins");
		}
		
		
		manipulator.countAverageLetters(testString);
		manipulator.reverse(testString);
		manipulator.reverseWords(testString);
		manipulator.isPalindrome("radar");
		manipulator.isPalindrome("cup");

	}

}
