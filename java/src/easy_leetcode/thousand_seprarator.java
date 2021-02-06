/**
 * 
 * Share
Given an integer n, add a dot (".") as the thousands separator and return it in string format.

 

Example 1:

Input: n = 987
Output: "987"
Example 2:

Input: n = 1234
Output: "1.234"
Example 3:

Input: n = 123456789
Output: "123.456.789"
Example 4:

Input: n = 0
Output: "0"
 */

class Solution {
    public String thousandSeparator(int n) {
        if(n == 0) return "0";
        StringBuilder res = new StringBuilder();
        int counter = 0;
        while(n > 0){
            int lastVal = n % 10;
            n = n / 10;
            if(counter == 3){
                res.append("." + lastVal);
                counter = 0;
            } else {
                res.append(lastVal);
            }
            counter++;
        }
        
        return res.reverse().toString();
        
    }
}