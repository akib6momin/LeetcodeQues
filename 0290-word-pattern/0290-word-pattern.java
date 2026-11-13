class Solution {
    public boolean wordPattern(String pattern, String s) {
        String words[] = s.split(" ");
        char p[] = pattern.toCharArray();

        if(words.length != p.length){
            return false;
        }

        HashMap<String, Character> stringToChar = new HashMap<>();
        HashMap<Character, String> charToString = new HashMap<>();

        for(int i=0; i<p.length; i++){
            String word = words[i];
            char ch = p[i];
            if(stringToChar.containsKey(word)){
                if(stringToChar.get(word)!=ch){
                    return false;
                }
            }else if(charToString.containsKey(ch)){
                if(!charToString.get(ch).equals(word)){
                    return false;
                }
            }else{
                stringToChar.put(word, ch);
                charToString.put(ch, word);
            }
        }

        return true;
    }
}