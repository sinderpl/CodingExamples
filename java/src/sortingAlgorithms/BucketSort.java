import java.util.ArrayList;

public class BucketSort extends sortingAlgorithm{

	/**
	 * Bucket list implementation 
	 * #TODO Warning ! In current form it works only for unsigned int
	 */
	@Override
	public ArrayList<Integer> sort(ArrayList<Integer> toSort) {
		
		ArrayList<Integer> sortedList = new ArrayList<>();
		
		//Retrieve the maximum value to find the size of the array to be created
		int maxSize = 0;
		for(Integer num : toSort)
		{
			if(num > maxSize)
			{
				maxSize = num;
			}
		}
		
		//Create the array
		int[] outputArray = new int[maxSize];
		
		//Iterate through the input again and begin sorting
		for(Integer num : toSort)
		{
			outputArray[num-1] += 1;
		}
		
		for(int x = 0; x < outputArray.length; x++)
		{
			if(outputArray[x] != 0)
			{
				for(int y = 0; y < outputArray[x] ; y++)
				{
					sortedList.add(x+1);
				}
			}
		}
		
		
		return sortedList;
	}

}
