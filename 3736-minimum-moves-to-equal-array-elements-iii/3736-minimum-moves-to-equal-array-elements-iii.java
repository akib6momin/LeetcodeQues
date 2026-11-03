class Solution {
    public int minMoves(int[] nums) {
        int maxi = Integer.MIN_VALUE;
        for(int num: nums){
            maxi = Math.max(maxi, num);
        }

        int ans = 0;
        for(int num: nums){
            ans+=(maxi-num);
        }

        return ans;
    }
}