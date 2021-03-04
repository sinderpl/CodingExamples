/**
 * Given an array of integers where 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.

Find all the elements of [1, n] inclusive that do not appear in this array.

Could you do it without extra space and in O(n) runtime? You may assume the returned list does not count as extra space.
 * 
 */

class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer>  result = new ArrayList<>();
        for(int i = 1; i < nums.length+1; i++){
            result.add(i);
        }
        
        for(int i = 0 ; i < nums.length; i++){
            result.remove(new Integer(nums[i]));
        }
        
        return result;
    }
}

//Proper solution
class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer>  result = new ArrayList<>();
        
        for(int i = 0; i < nums.length; i++){
            int val = Math.abs(nums[i]) -1;
            if (nums[val] > 0) {
                nums[val] = -nums[val];
            }           
        }
        
        for(int i = 0; i < nums.length; i++){
            if(nums[i] > 0)
                result.add(i+1);
        }
        return result;
    }
}