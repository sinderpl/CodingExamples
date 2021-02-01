/**
 * Given a string, find the first non-repeating character in it and return its index. If it doesn't exist, return -1.

Examples:

s = "leetcode"
return 0.

s = "loveleetcode"
return 2.
 * 
 */

 /**
  * not the best solution but the best ones realy on javas indexOf which is slight cheating 
  */
class Solution {
    public int firstUniqChar(String s) {
        if(s.isEmpty()) return -1;
        int[] letters = new int[26];
        for(int i = 0; i < 26; i++){
            letters[i] = -2;
        }
        
        
        for(int i = 0; i < s.length(); i++){
            char c =  s.charAt(i);
            if(letters[c - 'a'] == -2){
                letters[c - 'a'] = i;
            } else if (letters[c - 'a'] >= 0){
                letters[c - 'a'] = -1;
            }
        }
        
        int index = Integer.MAX_VALUE;
        boolean isFound = false;
         for(int i = 0; i < letters.length; i++){
            if(letters[i] >= 0){
                index = Math.min(index,letters[i]);
                isFound = true;
            }
         }
        
        
        return isFound ? index : -1;
    }
}