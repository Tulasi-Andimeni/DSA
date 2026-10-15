class Solution {
    public long rob(int[] nums, int[] colors) {
        
        long skip = 0;
        long take = nums[0];

        for(int i=1; i< nums.length;i++){
            long best = Math.max(skip, take);
            long newtake;

            if(colors[i] == colors[i-1]){
                newtake = skip + nums[i];
            }else{
                newtake = best + nums[i];
            }

            skip = best;
            take = newtake;
        }
        

        return Math.max(skip, take);
    }
}