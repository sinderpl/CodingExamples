/**
 * Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.
 */


class Solution {
    public void moveZeroes(int[] nums) {
        int zeroCount = 0;
        int curr = 0;
        
        //Move all occurences of num
        for(int i = 0; i < nums.length; i++){
            if(nums[i] != 0){
                nums[curr] = nums[i];
                curr++;
            } else {
                zeroCount++;
            }
        }
        
        //Zero the end of the array;
        for(int i = nums.length - zeroCount; i < nums.length; i++){
            nums[i] = 0;
        }
    }
}