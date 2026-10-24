import java.util.*;

class Solution {
    public static int trap(int[] height) {

        int left = 0, right = height.length-1;
        int leftMax = height[left], rightMax = height[right];
        int tappedWater = 0;

        while(left<right){
            if(height[left] < height[right]){
                left++;
                leftMax = Math.max(leftMax, height[left]);
                tappedWater+=leftMax-height[left];
            }else{
                right--;
                rightMax = Math.max(rightMax, height[right]);
                tappedWater+=rightMax-height[right];
            }
        }

        return tappedWater;
    }
}