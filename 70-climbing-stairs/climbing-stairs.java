class Solution {

    public static int rec(int i , int n, int[] dp){

        if(i == n){
            return 1;
        }

        if(i > n){
            return 0;
        }

        if(dp[i] != -1){
            return dp[i];
        }

        int cnt1 = 0;
        int cnt2 = 0;
        cnt1 = rec(i+1, n, dp);
        cnt2 = rec(i+2, n , dp);

        dp[i] = cnt1 + cnt2;

        return dp[i];

        
      
    }

    public int climbStairs(int n) {
    
        int dp[] = new int[n+1];
        Arrays.fill(dp, -1);
        return rec(0, n, dp);
    }
}