
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

//Actual solutons WORK BACKWARDS goddamn

public void duplicateZeros(int[] arr) {
    int zerocounts = 0;
    int len = arr.length - 1; //we only count up to len - zero because the left side will be pushed out until then
    for (int i = 0; i <= len - zerocounts; i++) {
        if (arr[i] == 0) {
            //Corner case for trailing zeroes
            if (i == len - zerocounts) { 
                arr[len] = 0;
                len--;
                break;
            }
            zerocounts++;
        }
    }
    System.out.println(zerocounts);
    System.out.println(Arrays.toString(arr));
    // Start moving from the last number occuring before being cut off,  the rest doesnt matter
    int last = len - zerocounts;
    //Work backawards one step at a time
    for (int i = last; i >= 0; i--) {
        //i +  zeroCount provides the actual index of where to move the paramete
        //AFTER the current index being moved.
        if (arr[i] == 0) {
            arr[i + zerocounts] = 0;
            zerocounts--;
            arr[i + zerocounts] = 0;
        } else {
            arr[i + zerocounts] = arr[i];
        }
        System.out.println(Arrays.toString(arr));
    }
}