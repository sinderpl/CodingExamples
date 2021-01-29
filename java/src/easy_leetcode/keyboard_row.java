/**
 * Given an array of strings words, return the words that can be typed using letters of the alphabet on only one row of American keyboard like the image below.
 */

class Solution {
    public String[] findWords(String[] words) {
        String[] rows = new String[]{"qwertyuiop", "asdfghjkl", "zxcvbnm"};
        
        int currentWordRow = -1;
        boolean isWordValid = false;
        ArrayList<String> outputWords = new ArrayList<>();
        int curr = 0;
        
        for(String word : words){
            for(String character : word.split("")){
                
                for(int x = 0; x < rows.length; x++){
                    if(rows[x].contains(character)){
                        if(currentWordRow == -1){
                            currentWordRow = x;
                            isWordValid = true;
                        } else if (currentWordRow != x){
                            isWordValid = false;
                            break;
                        }
                    }
                }
            }
            if(isWordValid){
                outputWords.add(word);
            }
            currentWordRow = -1;
            isWordValid = false;
        } 
        
        String[] strArr = new String[outputWords.size()];  
        strArr = outputWords.toArray(strArr);
        return strArr; 
    }
}