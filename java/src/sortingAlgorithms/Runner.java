package sortingAlgorithms;

import java.util.ArrayList;

public class Runner {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		mergeSort merge = new mergeSort();
		
		ArrayList<Integer> arr = new ArrayList<Integer>();
		
		arr.add(1);
		arr.add(2);
		arr.add(8);
		arr.add(15);
		
		System.out.println(merge.isSorted(arr));

	}

}
