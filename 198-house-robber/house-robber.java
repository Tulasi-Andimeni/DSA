class Solution {

    public static int rec(int i , int[] nums, int[] dp){

        if(i >= nums.length){
            return 0;
        }

        if(dp[i] != -1){
            return dp[i];
        }

        int pick = nums[i] + rec(i+2, nums, dp);
        int skip =  rec(i+1, nums, dp);

        dp[i] = Math.max(skip, pick);
        return dp[i];


    }
    public int rob(int[] nums) {

        int[] dp = new int[nums.length+1];

        Arrays.fill(dp, -1);
       return rec(0, nums, dp);


    }
}