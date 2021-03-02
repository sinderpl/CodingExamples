/**
 * Given an array nums of integers, return how many of them contain an even number of digits.
 */

class Solution {
    public int findNumbers(int[] nums) {
        int count = 0;
        
        for(int num : nums){
            if(isEvenLoop(num))
                count++;
        }
            
        return count;
    }
    private boolean isEvenLoop(int num){
        int count = 0;
        while(num != 0){
            count++;
            num /= 10;
        }
        
        return count % 2 == 0;
    }
}