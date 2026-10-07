class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int left = 0;
        int right = 0;
        for(int weight : weights){
            left = Math.max(left, weight);
            right += weight;
        }

        while(left <= right){
            int mid = left + (right -left)/2;

            if(canFinish(weights, days, mid)){
                right = mid -1;
            }else{
                left = mid +1;
            }
        }
        return left;
    }

    private boolean canFinish(int[] weights, int days, int capacity){
        int useddays = 1;
        int currweight = 0;
        for(int weight : weights){
            if(currweight + weight <= capacity){
                currweight += weight;
            }else{
                useddays++;
                currweight = weight;
            }
            
        }
        return useddays <= days;

       

    }
   
}