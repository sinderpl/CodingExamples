/**
 * 
 * Given an array of integers arr, return true if and only if it is a valid mountain array.

Recall that arr is a mountain array if and only if:

arr.length >= 3
There exists some i with 0 < i < arr.length - 1 such that:
arr[0] < arr[1] < ... < arr[i - 1] < arr[i]
arr[i] > arr[i + 1] > ... > arr[arr.length - 1]
 */

class Solution {
    public boolean validMountainArray(int[] arr) {
        if( arr.length < 3) return false;
        boolean isDecline = false;
        boolean isFirst = true;
        
        for(int i = 1; i < arr.length; i++){
            if(isDecline){
                if(arr[i] >= arr[i-1])
                    return false;
            } else if(arr[i] == arr[i-1]){
                return false;
            } else if (arr[i] <= arr[i-1]){
                if(!isFirst){
                  isDecline = true;  
                } else {
                    return false;
                }
            }
            isFirst = false;   
        }
        
        return isDecline;
    }
}

//Cleaner solution
class Solution {
    public boolean validMountainArray(int[] arr) {
        if( arr.length < 3) return false;
        int step = 0;
        
        //Walking up
        while(step + 1 < arr.length && arr[step] < arr[step+1]){
            step++;
        }
        
        if(step == 0 || step == arr.length - 1)
            return false;
        
        //Walk down
        while(step + 1 < arr.length && arr[step] > arr[step+1]){
            step++;
        }
        
        return step == arr.length-1;
    }
}