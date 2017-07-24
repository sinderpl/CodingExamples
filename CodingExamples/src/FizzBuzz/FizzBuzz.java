package FizzBuzz;
/**
 * 
 * @author Alan Niemiec
 *
 * A simple example of the FizzBuzz coding question.
 * 
 * "Write a program that prints the numbers from 1 to 100. 
 * But for multiples of three print “Fizz” instead of the number and for the multiples of five print “Buzz”. 
 * For numbers which are multiples of both three and five print “FizzBuzz”."
 */
public class FizzBuzz {
	public static void main(String[] args) {
		FizzBuzz fizzBuzz = new FizzBuzz();
		fizzBuzz.printFizzBuzz(50);
	}
	
	/**
	 * 
	 * @param size The amount of numbers to be printed
	 * eg. 100 = Numbers from 1 - 100 inclusive.
	 */
	public void printFizzBuzz( int size){
		
		//Count from 1 to the size specified
		for(int num=1; num<=size; num++){
			//If the number is a multiple of both 3 and 5
			if(num%5==0 && num%3==0)
				System.out.println("FizzBuzz");
			//If the number is a multiple of 5
			else if(num%5==0)
				System.out.println("Buzz");
			//If the number is a multiple of 3
			else if (num%3==0)
				System.out.println("Fizz");
			//If none of the above just print the number
			else
				System.out.println(num);
		}
		
	}
}
