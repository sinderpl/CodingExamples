/**
 * Given an integer array nums sorted in non-decreasing order, return an array of the squares of each number sorted in non-decreasing order.

 

Example 1:

Input: nums = [-4,-1,0,3,10]
Output: [0,1,9,16,100]
Explanation: After squaring, the array becomes [16,1,0,9,100].
After sorting, it becomes [0,1,9,16,100].
Example 2:

Input: nums = [-7,-3,2,3,11]
Output: [4,9,9,49,121]
 */

class Solution {
    public int[] sortedSquares(int[] nums) {
        for(int i = 0; i < nums.length; i++){
            nums[i] *= nums[i]; 
        }
        Arrays.sort(nums);
        return nums;
    }
}


/**
 * This is a really cool solution utilising binary search to insert values at right point in the code.
 * I believe it will only however work for non decreasing arrays
 * 
 */

class Solution {
    public int[] sortedSquares(int[] nums) {
        int[] res = new int[nums.length];
        //Keep track of left and right indexes to slowly move inwards using two pointes
        int l = 0, r = nums.length - 1;
        //normal index track to keep of 
        int index = r;
        
        while(l  <= r){
            // The absolute value here is a non negative representation of a number
            // We simply choose the bigger value at each step since pow will remove any negative signs.
            // The biggest value is then appended to the end of the array.
            if(Math.abs(nums[l]) > Math.abs(nums[r])){
                res[index--] = nums[l] * nums[l];
                l++;
            } else {
                res[index--] = nums[r] * nums[r];
                r--;
            }
        }
        return res;
    }
}