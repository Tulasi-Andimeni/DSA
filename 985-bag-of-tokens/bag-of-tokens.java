class Solution {
    public int bagOfTokensScore(int[] tokens, int power) {
        Arrays.sort(tokens);
        int score = 0;
        int maxscore = 0;
        int left = 0, right = tokens.length -1;

        while(left <= right){

            

            if(power >= tokens[left]){
                power = power - tokens[left];
                left++;
                score++;
                maxscore = Math.max(score, maxscore);

            }else if(score > 0){
                power = power + tokens[right];
                right--;
                score--;
            }else{
                break;
            }
           
        }
        return maxscore;
    }
}