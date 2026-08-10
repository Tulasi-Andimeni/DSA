class Solution {
    public boolean winnerSquareGame(int n) {
        boolean[] dp = new boolean[n+1];

        for(int i =1; i <= n; i++){
            for(int j = 1; j * j <= i; j++){

                int sq = j*j;

                if(dp[i - sq] == false){
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[n];
        
    }
}