package sortingAlgorithms;

import java.util.ArrayList;

import com.sun.xml.internal.bind.v2.runtime.reflect.ListIterator;
import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader.Array;

public class ComparisonSort extends sortingAlgorithm{

	/**
	 * Implements the sorting algorithm for this class
	 * @param toSort Integer array you want to sort
	 */
	public ArrayList<Integer> sort(ArrayList<Integer> toSort) {
		
		//Boolean flag used to check if the array is sorted
		boolean isSorted = false;
		//Temporary array list used to modify the array during for loop execution
		ArrayList<Integer> answer = toSort;
		///Used for temporarily storing one of the array variables
		int temp;
		
		//Iterate until array is sorted and boolean defaults to true
		while (!isSorted){
			//Set the boolean to true so we can check if it is sorted during the final pass
			//This means it will be set to false only when the if statement triggers
			isSorted = true;
			for(int x = 0; x < toSort.size()-1; x++){
				//Check if the current field is smaller than the next one
				if(toSort.get(x) > toSort.get(x+1)){
					//Set the current value of x to a temporary variable
					temp = toSort.get(x);
					//Set the variables to their new values
					//This is done in the temporary array to avoid problems during execution
					answer.set(x, x+1);
					answer.set(x+1, temp);
					//Set the boolean flag to false since there was a change during this pass
					isSorted = false;
				}
			}
			toSort = answer;
		}
		System.out.println("The array sorted using Comparison Sort");
		System.out.printf("The array is sorted: %b \n" , super.isSorted(answer));
		return answer;
		
	}

	
}
