class Solution {
    public int deleteAndEarn(int[] nums) {
        int max = 0;

        for(int num : nums){
            max = Math.max(max, num);
        }

        int[] point = new int[max+1];

        for(int num : nums){
            point[num] += num;
        }

        int[] dp = new int[max+1];
        Arrays.fill(dp, -1);

        return rec(max, point, dp);
    }

    public int rec(int i, int[] point, int[] dp){

        if(i == 0){
            return point[i];
        }

        if(i == 1){
            return point[i];
        }

        if(dp[i] != -1){
            return dp[i];
        }

        int pick = point[i] + rec(i-2, point, dp);
        int skip = rec(i-1, point, dp);

        return dp[i] = Math.max(pick, skip);
    }
}