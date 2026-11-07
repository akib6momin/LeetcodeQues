class Solution {

    public int isPossible(int arr[], int reqSum){

        int cnt = 1;
        int sum = 0;
        for(int i=0; i<arr.length; i++){
            if((sum+arr[i])<=reqSum){
                sum+=arr[i];
            } else{
                sum = arr[i];
                cnt++;
            }
        }

        return cnt;
    }

    public int splitArray(int[] nums, int k) {
        int maxi = Integer.MIN_VALUE;
        int sum =  0;

        for(int val: nums){
            maxi = Math.max(maxi, val);
            sum += val;
        }

        int low = maxi;
        int high = sum;
        int ans = -1;
        while(low<=high){
            int mid = low + (high-low)/2;

            if(isPossible(nums, mid)<=k){
                ans = mid;
                high = mid-1; // it is porrible or causing less subarrays than required so we need to reduce the sum get valid answer
            } else{
                low = mid+1; // getting more subarray so increase the sum to get less or equal
            }
        }

        return ans;
    }
}