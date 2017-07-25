package GoldenRatioFacadePattern;

import java.util.ArrayList;

/**
 * 
 * @author Alan Niemiec
 *
 * Calculates the Lucas sequence
 * Starts with seeds of L1 = 2 & L2 = 1
 */
public class Lucas implements INumberSequence{
	//ArrayList storing the numbers
	private ArrayList<Integer> sequence = new ArrayList<Integer>();
	//Saving the previous number for reference on recursive iteration
	private int prevNum = 2;

	/**
	 * Calculate the Lucas sequence using for loops
	 */
	public void calculate(int size) {
		
		//Variables to keep track of the numbers
		// Contain initial seed values
		int prev = 2;
		int curr = 1;
		//Add the values to the sequence array
		sequence.add(prev);
		sequence.add(curr);
		for(int x=0; x<=size-2; x++){
			//Create the new number by evaluating previous + current
			int newNumber = prev + curr;
			//Assign the current number to the previous variable for reference on next iteration
			prev = curr;
			//Set the new number to the current variable for evaluation in next iteration
			curr = newNumber;
			//Add the number to the sequence array
			sequence.add(newNumber);
		}
		
	}

	/**
	 * Calculate the Lucas sequence recursively
	 */
	public int calculateRecursively(int size) {
		//Start returning when the size variable reaches 0
		if (size <= 0)
			//The Lucas seed L2 = 1 which is why this is returned
			return 1;
		else{
			// Call the function again and wait until it returns
			// Decrease the size by one each time until it reaches 0
			int currentNum = calculateRecursively(size - 1);
			//Create the new number in the Lucas sequence by adding the previous number and the current one
			int newNum = prevNum + currentNum ; 
			// Set the current number to be equal to the previous variable for next calculation
			prevNum = currentNum;
			//Add the new number to the sequence
			sequence.add(newNum);
			//Return the newly created number for further calculation
			return newNum;
		}
	}
	/**
	 * Returns the number sequence
	 */
	public ArrayList<Integer> getSequence() {
		return sequence;
	}
	
	
}
