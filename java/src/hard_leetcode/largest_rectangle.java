/***Given n non-negative integers representing the histogram's bar height where the width of each bar is 1, find the area of largest rectangle in the histogram.

 


Above is a histogram where width of each bar is 1, given height = [2,1,5,6,2,3].

 


The largest rectangle is shown in the shaded area, which has area = 10 unit.

 

Example:

Input: [2,1,5,6,2,3]
Output: 10
 

Example 1:


Input: heights = [2,1,5,6,2,3]
Output: 10
Explanation: The above is a histogram where width of each bar is 1.
The largest rectangle is shown in the red area, which has an area = 10 units.
Example 2:


Input: heights = [2,4]
Output: 4
 

Constraints:

1 <= heights.length <= 105
0 <= heights[i] <= 104
 * 
 */

class Solution {
    public int largestRectangleArea(int[] heights) {
        if(heights.length == 0) return 0;
        int largestRect = 0;
        // ArrayList<Integer> areas = new ArrayList<>();
        for(int i = 0; i < heights.length; i++){
            int currArea = 0, length = 1, height = heights[i];
            // areas.add();
            largestRect = Math.max(largestRect, length * height);
            for(int j = i + 1; j < heights.length; j++){
                length++;
                if(height > heights[j]){
                    height = heights[j];
                }
                largestRect = Math.max(largestRect, length * height);
            }
        }
        return largestRect;
        
    }
}