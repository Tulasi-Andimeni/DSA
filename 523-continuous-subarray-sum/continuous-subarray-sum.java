class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        HashMap <Integer, Integer> map = new HashMap<>();

        map.put(0, -1);

        int sum = 0;

        for(int i = 0; i < nums.length; i++){

            sum += nums[i];

            int req = sum % k;

            if(req < 0){
                req += k;
            }

            if(map.containsKey(req)){

                if(i - map.get(req) >= 2){
                    return true;
                }
            }
            else{
                map.put(req, i);
            }
        }
        return false;
    }
}