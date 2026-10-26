class Solution {
    public int findNumbers(int[] nums) {
        int ans = 0;
        for(int i=0; i<nums.length; i++){
            if(digits(nums[i])%2==0){
                ans++;
            }
        }

        return ans;
    }

    public int digits(int n){
        int cnt = 0;
        while(n>0){
            cnt++;
            n/=10;
        }

        return cnt;
    }
}