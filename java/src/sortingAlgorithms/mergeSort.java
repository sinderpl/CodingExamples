package sortingAlgorithms;

import java.util.ArrayList;

/**
 * 
 * @author Alan Niemiec
 * 
 * Joins two sorted arrays so the end result is a 
 * new sorted array
 *
 */
public class mergeSort extends sortingAlgorithm {

	//TODO fixes needed for this method
	/**
	 * Combines two sorted integer arrays into a single sorted array
	 * @param first Sorted integer array number one
	 * @param second Sorted interger array number two
	 * @return A sorted array combining the two arrays
	 */
	public ArrayList<Integer> mergeArrays(ArrayList<Integer> first, ArrayList<Integer> second){
		//Initialise the output array
		ArrayList<Integer> result = new ArrayList<Integer>();
		//Boolean check  whether the array is sorted
		boolean isSorted = false;
		
		int left = 0;
		int right = 0;
		
		int totalSize = first.size() + second.size();
		totalSize -= 2;
		
		for(int x= totalSize; x >=0 ; x--){
			//TODO This breaks when you have for example three 4's in the two arrays
			if(first.get(left) > second.get(right)){
				result.add(second.get(right));
				right++ ;
			}
			else{
				result.add(first.get(left));
				left++;
			}
		}
		
		System.out.println("New array is sorted: " + isSorted(result));
		
		
		//Return the output
		return result;
	}

	/**
	 * Sorts and returns a integer array using the merge method
	 * @param arr A array that is to be sorted 
	 * @return A array sorted using merge sort
	 */
	public ArrayList<Integer> mergeSortArray(ArrayList<Integer> arr){
		
		//If the list is empty return the the original list
		if (arr.size() <= 1){
			return arr;
		}
		//The output array
		ArrayList<Integer> result = new ArrayList<Integer>();
		
		//Temporary arrays for both sides
		ArrayList<Integer> first = new ArrayList<Integer>(arr.subList(0, arr.size()/2));
		ArrayList<Integer> second = new ArrayList<Integer>(arr.subList(arr.size()/2, arr.size()));
		
		System.out.println("first: " + first);
		System.out.println("second: " + second);
		System.out.println("---------------");
		//Call the method recursively to sort the arrays further
		first = mergeSortArray(first);
		second = mergeSortArray(second);
		
		ArrayList<Integer> temp = merge(first,second);
		result.addAll(temp); 
		System.out.println("Output: " + merge(first,second));
		//Return the new sorted array
		return result;
	}
	
	
	public ArrayList<Integer> merge(ArrayList<Integer> first, ArrayList<Integer> second){
		//Resulting array
		ArrayList<Integer> result = new ArrayList<Integer>();
		
		//Starting positions for the arrays
		int firstSize = 0;
		int secondSize = 0;
		
		// Runs until the both initial arrays are exhausted
		while(firstSize < first.size() && secondSize < second.size()){
			if (first.get(firstSize) < second.get(secondSize)){
				result.add(first.get(firstSize));
				firstSize++;
			}else{
				result.add(second.get(secondSize));
				secondSize++;
			}
		}
		
		//Return the two sorted arrays
		return result;
	}

	@Override
	public ArrayList<Integer> sort(ArrayList<Integer> toSort) {
		// TODO Auto-generated method stub
		return null;
		
	}
}
