class Solution {
    public int subarraySum(int[] nums, int k) {

       HashMap<Integer, Integer> map = new HashMap<>();

       int sum = 0;
       int count = 0;
       map.put(0, 1);

       for(int num : nums){
            sum += num;

            int req = sum - k;

            if(map.containsKey(req)){
                count += map.get(req);
                
            }
            map.put(sum, map.getOrDefault(sum, 0) +1);
       }
       return count;
        
    }
}