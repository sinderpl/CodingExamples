/**
 * Given an arbitrary ransom note string and another string containing letters from all the magazines, write a function that will return true if the ransom note can be constructed from the magazines ; otherwise, it will return false.

Each letter in the magazine string can only be used once in your ransom note.

 

Example 1:

Input: ransomNote = "a", magazine = "b"
Output: false
Example 2:

Input: ransomNote = "aa", magazine = "ab"
Output: false
Example 3:

Input: ransomNote = "aa", magazine = "aab"
Output: true
 */

class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        if(ransomNote.length() > magazine.length()){
            return false;
        }
        
        HashMap<Character, Integer> availableLetters = new HashMap<>();
        for(char c : magazine.toCharArray()){
            if(availableLetters.containsKey(c)){
                availableLetters.put(c, availableLetters.get(c) + 1);
            } else {
                availableLetters.put(c, 1);
            }
        }
        
        
        for(char c : ransomNote.toCharArray()){
            if(availableLetters.containsKey(c) && availableLetters.get(c) > 0){
                availableLetters.put(c, availableLetters.get(c) -1);
            } else {
                return false;
            }
        }
        return true;
        
    }
}

/**
 * Persibak faster solution utilising a simple hashtable instead ( assumes only a standard 26 character alphabet)
 */

class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        if(ransomNote.length() > magazine.length()){return false;}
        int[] alpha = new int[26];
        for(char c : magazine.toCharArray()){
            alpha[c - 'a'] = alpha[c - 'a'] + 1;
        }
        
        for(char c : ransomNote.toCharArray()){
            if(alpha[c - 'a'] > 0){
                alpha[c - 'a'] = alpha[c - 'a'] -1;
            } else{
                return false;
            }
        }
        return true;
    }
}