/**
 * 
 * Given a string, you need to reverse the order of characters in each word within a sentence while still preserving whitespace and initial word order.

Example 1:
Input: "Let's take LeetCode contest"
Output: "s'teL ekat edoCteeL tsetnoc"
Note: In the string, each word is separated by single space and there will not be any extra space in the string.

Accepted
 */


class Solution {
    public String reverseWords(String s) {
        String reverse = "";
        StringBuilder result = new StringBuilder();
        for(String p : s.split("")){
            result.append(p.reverse());
        }
        return result.toString(); 
    }
}