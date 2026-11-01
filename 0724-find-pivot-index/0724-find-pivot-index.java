class Solution {
    public int pivotIndex(int[] nums) {
        int sum = 0;
        
        // Step 1: Calculate total sum
        for(int num : nums){
            sum += num;
        }
        
        int left = 0;
        
        // Step 2: Traverse and check pivot
        for(int i = 0; i < nums.length; i++){
           sum -= nums[i];
            
            if(sum == left){
                return i;
            }
            
            left += nums[i];
        }
        
        return -1;
    }
}