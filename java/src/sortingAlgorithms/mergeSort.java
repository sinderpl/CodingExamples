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
}
