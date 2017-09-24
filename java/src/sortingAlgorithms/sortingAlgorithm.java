package sortingAlgorithms;

import java.util.ArrayList;
/**
 * 
 * @author Alan Niemiec
 * 
 * A parent class for the sorting algorithms.
 */
public abstract class sortingAlgorithm {

	/**
	 * Checks value by value to see whether the array is sorted
	 * @param arr The integer array to be verified
	 * @return A boolean value representing whether the array is sorted
	 */
	public boolean isSorted(ArrayList<Integer> arr){
		if(arr.size() > 0){
			//Iterate through each value checking if it is smaller
			//Than the previous one
			for(int x = 0; x < arr.size()-1; x++){
				//Check if the current value is bigger than the following one
				if(arr.get(x) > arr.get(x+1)){
					return false;
				}
			}
			//Return the results
			return true;
		}else
			return false;
	}//End of method
	
	/**
	 * To be implemented by any children allowing for a universal sorting name
	 * @param toSort Integer array you want to sort
	 */
	public abstract ArrayList<Integer> sort(ArrayList<Integer> toSort);

}//End of class
