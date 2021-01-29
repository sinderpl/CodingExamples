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


    /**
     * Much faster and less space since it uses a hashtable for ascii
     */
    public String[] findWords(String[] words) {
        
        int[] charHash = new int[26];
        for(char c : "qwertyuiop".toCharArray()){ charHash[c - 'a'] = 1;}
        for(char c : "asdfghjkl".toCharArray()){ charHash[c - 'a'] = 2;}
        for(char c : "zxcvbnm".toCharArray()){ charHash[c - 'a'] = 3;}
        ArrayList<String> outputs = new ArrayList<>();
        
        for(String word : words){
            int curr = -1;
            boolean canType = false;
            for(char c : word.toCharArray()){
                char h = Character.toLowerCase(c);
                if(curr == -1){
                    curr = charHash[h - 'a'];
                    canType = true;
                } else if (curr != charHash[h - 'a']){
                    canType = false;
                    break;
                }
            }
            if(canType) {outputs.add(word);}
            curr = -1;
            canType = false;
        }
        
        String[] wordsArr = new String[outputs.size()];
        wordsArr = outputs.toArray(wordsArr);
        return wordsArr;
    }


}