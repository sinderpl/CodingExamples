import java.util.ArrayList;

/**
 * Selection Sort
 * 
 * The sort iterates through each value in the arrayList,
 * it then takes the minimum value and compares it against
 * the other values, swapping them if the other value
 * is smaller than the minimum.
 *
 */
public class SelectionSort extends sortingAlgorithm{

	@Override
	public ArrayList<Integer> sort(ArrayList<Integer> toSort) 
	{	
		//Outer iteration through each value
		for(int x = 0; x < toSort.size(); x++)
		{
			int min = x;
			//Inner iteration for checking each value against the lower ones
			for(int y = x+1; y < toSort.size(); y++)
			{
				if(toSort.get(y) < toSort.get(min))
				{
					min = y;
				}
				int temp = toSort.get(x);
				toSort.set(x, toSort.get(min));
				toSort.set(min, temp);
			}
		}
		
		return toSort;
	}

}
