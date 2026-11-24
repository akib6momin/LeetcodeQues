class Solution {
    public boolean halvesAreAlike(String s) {
        int mid = s.length() / 2;
        if(totalVowels(s.substring(0, mid)) == totalVowels(s.substring(mid))){
            return true;
        }

        return false;
    }

    public int totalVowels(String str){
        int cnt=0;
        for(char ch: str.toCharArray()){
            if(ch == 'a' || ch=='A' || ch == 'e' || ch=='E' ||
            ch == 'i' || ch=='I'|| ch == 'o' || ch == 'O' || 
            ch == 'u' || ch == 'U'){
                cnt++;
            }
        }

        return cnt;
    }
}