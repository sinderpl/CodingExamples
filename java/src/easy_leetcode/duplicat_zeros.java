
/**
 * Given a fixed length array arr of integers, duplicate each occurrence of zero, shifting the remaining elements to the right.

Note that elements beyond the length of the original array are not written.

Do the above modifications to the input array in place, do not return anything from your function.

 
 */

class Solution {
    public void duplicateZeros(int[] arr) {
        ArrayList<Integer> change = new ArrayList<>();
        
        for(int i = 0; i < arr.length; i++){
            change.add(arr[i]);
        }
        
        int curr = 0;
        for(int num : change){
            if(curr >= arr.length){
                return;
            } else if (num == 0){
                arr[curr++] = 0;
                if(curr < arr.length)
                    arr[curr++] = 0;
            } else {
                arr[curr++] = num;
            }
        }
            
    }
}