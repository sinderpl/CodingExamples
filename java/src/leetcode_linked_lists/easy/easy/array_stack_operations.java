/**
 * Given an array target and an integer n. In each iteration, you will read a number from  list = {1,2,3..., n}.

Build the target array using the following operations:

Push: Read a new element from the beginning list, and push it in the array.
Pop: delete the last element of the array.
If the target array is already built, stop reading more elements.
Return the operations to build the target array. You are guaranteed that the answer is unique.
 */

class Solution {
    public List<String> buildArray(int[] target, int n) {
        List<String> res = new ArrayList<>();
        //if(target.length == 0 || n = 0) return res;
        int numCount = 0;
        int curr = 1;
        boolean[] isPresent = new boolean[n+1];
        for(int num : target){
            isPresent[num] = true;
            numCount++;
        }
        
        while(curr <= n){
            res.add("Push");
            if(!isPresent[curr])
                res.add("Pop");
            else
                numCount--;
                if(numCount == 0)
                    return res;
            curr++;
        }
        return res;
    }
}