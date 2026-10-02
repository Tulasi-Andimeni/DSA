class Solution {
    public int jump(int[] nums) {
        int jump = 0, currend = 0, forther = 0;

        for(int i = 0; i < nums.length - 1; i++){

            forther = Math.max(forther, i + nums[i]);

            if(i == currend){
                jump++;
                currend = forther;
            }
        }
        return jump;
    }
}