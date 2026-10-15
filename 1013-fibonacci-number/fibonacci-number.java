class Solution {
    public static int rec( int n, int[] dp){
        if(n == 0){
            return 0;
        }
        if(n == 1){
            return 1;
        }

        if(dp[n] != -1){
            return dp[n];
        }

        dp[n] = rec(n-1, dp) + rec(n-2, dp);
        return dp[n];
    }

    public int fib(int n) {
        int[] dp = new int[n+1];

        Arrays.fill(dp, -1);

        return rec( n, dp);
    }
}