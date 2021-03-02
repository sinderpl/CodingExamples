/**
 * Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.

The number of elements initialized in nums1 and nums2 are m and n respectively. You may assume that nums1 has a size equal to m + n such that it has enough space to hold additional elements from nums2.

 

Example 1:

Input: nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
Output: [1,2,2,3,5,6]
Example 2:

Input: nums1 = [1], m = 1, nums2 = [], n = 0
Output: [1]
 */

class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if(n == 0){
            return;
        }
        int end = m + n -1;
        m--;
        n--;
        
        while(end >= 0){
            if( m >= 0 && n >= 0){
                if( nums1[m] > nums2[n]){
                    nums1[end] = nums1[m];
                    m--;
                } else {
                    nums1[end] = nums2[n];
                    n--;
                }
            } else if ( m >= 0){
                nums1[end] = nums1[m];
                m--;
            } else {
                nums1[end] = nums2[n];
                n--;
            }
            end--;
        }
        
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (n == 0){
            return;
        }
        
        int end = m + n -1;
        m--; n--;
        
        while(m >= 0 && n >= 0){
            if(nums1[m] > nums2[n])
                nums1[end--] = nums1[m--];
            else
                nums1[end--] = nums2[n--];
        }
        
        while(n >= 0)
            nums1[end--] = nums2[n--];
    }
}
}