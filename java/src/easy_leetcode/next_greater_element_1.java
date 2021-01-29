/**
 * You are given two integer arrays nums1 and nums2 both of unique elements, where nums1 is a subset of nums2.

Find all the next greater numbers for nums1's elements in the corresponding places of nums2.

The Next Greater Number of a number x in nums1 is the first greater number to its right in nums2. If it does not exist, return -1 for this number.
 */

public class next_greater_element_1{
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] output = new int[nums1.length];
        int curr = 0;
        
        for(int i = 0; i < nums1.length; i++){
            output[curr] = -1;
            for(int y = i; y < nums2.length; y ++){
                if(nums2[y] > nums1[i]){
                    output[curr] = nums2[y];
                    break;
                }
            }
            curr++;
        }
        
        return output;
    }
}