class Solution {
    public int arraySign(int[] nums) {
        int prod = 1;
        for(int val : nums){
            if(val<0){
                prod*=-1;
            }else if(val > 0){
                prod*=1;
            }else{
                return 0;
            }
        }

        if(prod < 0){
            return -1;
        }else if(prod > 0){
            return 1;
        }

        return 0;
    }
}