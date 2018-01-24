import java.util.ArrayList;

/**
 * Basic implementation of the bubble sort algorithm
 *
 * The sort iterates through each number then compares
 * the current number to the next one, swapping them
 * if necessary.
 * The sort is executed until a swap free pass is made
 * 
 */
public class BubbleSort extends sortingAlgorithm {

	@Override
	public ArrayList<Integer> sort(ArrayList<Integer> toSort) {

		boolean isSorted = false;

		if (toSort.size() == 1 || toSort.isEmpty()) {
			return toSort;
		}

		while (!isSorted) {
			isSorted = true;
			
			//Iterate through each number
			for (int x = 0; x < toSort.size()-1; x++) 
			{
				if (toSort.get(x + 1) != null && toSort.get(x) > toSort.get(x + 1)) 
				{
					//Swap
					Integer temp = toSort.get(x + 1);
					toSort.set(x+1, toSort.get(x));
					toSort.set(x, temp );
					
					isSorted = false;
				}
			}
		}

		return toSort;
	}

}
