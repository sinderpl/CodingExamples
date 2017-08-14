package sortingAlgorithms;

import java.util.ArrayList;

public class Runner {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		mergeSort merge = new mergeSort();
		
		ArrayList<Integer> arr1 = new ArrayList<Integer>();
		ArrayList<Integer> arr2 = new ArrayList<Integer>();
		
		arr1.add(1);
		arr1.add(8);
		arr1.add(2);
		arr1.add(15);
		
		arr2.add(3);
		arr2.add(4);
		arr2.add(6);
		arr2.add(9);
		
		System.out.println(merge.isSorted(arr1));
		System.out.println(merge.isSorted(arr2));
		
		System.out.println(merge.mergeArrays(arr1, arr2));

	}

}
