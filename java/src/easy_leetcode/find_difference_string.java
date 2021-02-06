/**
 * You are given two strings s and t.

String t is generated by random shuffling string s and then add one more letter at a random position.

Return the letter that was added to t.
 */


class Solution {
    public char findTheDifference(String s, String t) {
        int[] letters = new int[26];
        
        for(int c : t.toCharArray()){
            letters[c -'a']++;
        }  
        
        for(int c : s.toCharArray()){
            letters[c -'a']--; 
        }
        
        for(int i=0;i<26;i++){
            if(letters[i]==1) return (char) ('a'+i);
        }
        return 'a';
    }
}


/**
 * We only need to calculate the totals 
 */
class Solution {
    public char findTheDifference(String s, String t) {
        int totalT  = 0;
        for(char c : t.toCharArray()){
            totalT += c;
        }
        
        for(char c : s.toCharArray()){
            totalT -= c;
        }
        return (char)totalT;
    }
}