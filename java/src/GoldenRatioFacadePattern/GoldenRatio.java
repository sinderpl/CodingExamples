package GoldenRatioFacadePattern;

import java.awt.font.NumericShaper.Range;
import java.util.ArrayList;

/**
 * 
 * @author Alan Niemiec
 *
 * A class for calculating the Golden Ratio with phi rounded to power of n
 */
public class GoldenRatio implements INumberSequence{
	//ArrayList for storing the GoldenRatio number sequence
	private ArrayList<Integer> sequence = new ArrayList<Integer>();
	
	//Phi rounded off to the first three decimals as per the specification
	private final double phi = 1.618;
	
	/**
	 * Calculates the Golden Ratio sequence with seed value of phi= 1.618 multiplied to the power of n
	 * @param sequenceSize the size of the sequence generated
	 */
	public void calculate(int size){
		for(int x=0; x<=size; x++){
			//Creates the number in the sequence based on a formula : phi^x
			//Rounded off to a integer as per the specification
			int number = (int)Math.round(Math.pow(phi, x));
			//Add the number to the storage sequence
			sequence.add(number);
		}
	}
	
	/**
	 * Calculate the Golden Ratio sequence recursively
	 */
	public int calculateRecursively(int size) {
		//Runs down until the size reaches zero and then starts returning
		if(size <= 0)
			return size;
		else{
			//Calls the method again with decreased size
			//When that returns it assigns the number to the power variable
			int power = calculateRecursively(size-1);
			//Calculate the number based on formula: phi^x
			//Rounds off the nearest integer
			int number = (int) Math.round(Math.pow(phi, power));
			//Increase the power for next calculation
			power ++;
			//Add the number to the sequence 
			sequence.add(number);
			//Returns the updated power
			return power;
		}
	}
	
	
	/**
	 * Returns the sequence of Golden ratio numbers
	 */
	public ArrayList<Integer> getSequence() {
		return this.sequence;
	}

	
}
