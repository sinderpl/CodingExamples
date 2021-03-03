/**
 * Given an array nums and a value val, remove all instances of that value in-place and return the new length.

Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.

The order of elements can be changed. It doesn't matter what you leave beyond the new length.

Clarification:

Confused why the returned value is an integer but your answer is an array?

Note that the input array is passed in by reference, which means a modification to the input array will be known to the caller as well.
 */

class Solution {
    public int removeElement(int[] nums, int val) {
        int trueLength = 0;
        
        for(int i = 0; i < nums.length; i++){
            if(nums[i] != val){
                nums[trueLength] = nums[i];
                trueLength++;
            }
        }
        
        return trueLength;
        
    }
}