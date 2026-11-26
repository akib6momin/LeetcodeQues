class Solution {
    public boolean digitCount(String num) {
        int freq[] = new int[10];
        for(int i=0; i<num.length(); i++){
            int curr = num.charAt(i) - '0';
            freq[curr]++;
        }

        for(int i=0; i<num.length(); i++){
            int curr = num.charAt(i) - '0';
            if(freq[i]!=curr){
                return false;
            }
        }

        return true;
    }
}