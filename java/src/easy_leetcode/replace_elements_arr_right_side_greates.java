/**
 * Given an array arr, replace every element in that array with the greatest element among the elements to its right, and replace the last element with -1.

After doing so, return the array.
 */

class Solution {
    public int[] replaceElements(int[] arr) {
        if (arr.length < 1) return arr;
        int max = -1;
        for(int i = arr.length-1; i >= 0; i--){
            int temp = arr[i];
            arr[i] = max;
            max = Math.max(temp, max);
        }
        return arr;
    }
}