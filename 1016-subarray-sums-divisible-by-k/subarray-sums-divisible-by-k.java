class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        int[] rem  = new int[k];
        int sum =0, count =0;

        rem[0] = 1;

        for(int num : nums){
            sum += num;

            int req = sum % k;

            if(req < 0){
                req += k;
            }

            count += rem[req];
            rem[req]++;

        }
        return count;

        
    }
}