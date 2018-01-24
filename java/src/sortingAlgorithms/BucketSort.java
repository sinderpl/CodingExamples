import java.util.ArrayList;

public class BucketSort extends sortingAlgorithm {

	/**
	 * Bucket list implementation 
	 * #TODO Warning ! In current form it works only for unsigned int
	 * 
	 * (O)n algorithm type 
	 * The algorithm creates an array of fixed size x where
	 * x is the largest value in the input 
	 * We then iterate through each number
	 * in the input array and increment the counter for the corresponding
	 * index value
	 * 
	 * We then iterate through each index of the array list and append
	 * the index times the amount specified int the value under the index
	 */
	@Override
	public ArrayList<Integer> sort(ArrayList<Integer> toSort) {

		ArrayList<Integer> sortedList = new ArrayList<>();

		// Retrieve the maximum value to find the size of the array to be
		// created
		int maxSize = 0;
		for (Integer num : toSort) {
			if (num > maxSize) {
				maxSize = num;
			}
		}

		// Create the array
		int[] outputArray = new int[maxSize];

		// Iterate through the input again and begin sorting
		for (Integer num : toSort) {
			outputArray[num - 1]++;
		}

		for (int x = 0; x < outputArray.length; x++) {
			// Not necessary but can perhaps save time
			if (outputArray[x] != 0) {
				// For the number that the index represents
				// add y amount of instances of that number to
				// your output array
				for (int y = 0; y < outputArray[x]; y++) {
					sortedList.add(x + 1);
				}
			}
		}

		return sortedList;
	}

}
