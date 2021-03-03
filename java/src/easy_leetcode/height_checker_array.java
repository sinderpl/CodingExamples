/**
 * Students are asked to stand in non-decreasing order of heights for an annual photo.

Return the minimum number of students that must move in order for all students to be standing in non-decreasing order of height.

Notice that when a group of students is selected they can reorder in any possible way between themselves and the non selected students remain on their seats.

 
 */

class Solution {
    public int heightChecker(int[] heights) {
        int[] copy  = Arrays.copyOf(heights, heights.length);
        Arrays.sort(copy);
        int diff = 0;
        
        for(int i = 0; i < heights.length; i++){
            if(heights[i] != copy[i])
                diff++;
        }
        return diff;
    }
}