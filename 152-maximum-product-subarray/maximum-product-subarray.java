class Solution {
    public int maxProduct(int[] nums) {
     int ans = nums[0];
     int maxsum = nums[0];
     int minsum = nums[0];
        
        for(int i = 1; i < nums.length; i++){
           if(nums[i] < 0){
                int temp = maxsum;
                maxsum = minsum;
                minsum = temp;
           }

           maxsum = Math.max(nums[i], maxsum * nums[i]);
           minsum = Math.min(nums[i], minsum * nums[i]);
           ans = Math.max(ans, maxsum);
        }
        return ans;
    }
}