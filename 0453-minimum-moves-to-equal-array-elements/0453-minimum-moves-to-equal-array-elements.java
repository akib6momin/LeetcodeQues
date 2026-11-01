class Solution {
    public int minMoves(int[] nums) {
        int ans = 0;
        int min = Integer.MAX_VALUE;

        for(int i=0; i<nums.length; i++){
           min = Math.min(nums[i], min);
        }

        for(int num : nums){
            ans+=(num-min);
        }

        return ans;
    }
}