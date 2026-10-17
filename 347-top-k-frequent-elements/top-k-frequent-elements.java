class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int num : nums){
            map.put(num, map.getOrDefault(num, 0)+1);
        }

        List<Integer>[] bucket = new List[nums.length+1];

        for(int num : map.keySet()){
            int count = map.get(num);

            if(bucket[count] == null){
                bucket[count] = new ArrayList<>();
            }

            bucket[count].add(num);
        }

        int[] ans = new int[k];
        int index = 0;

        for(int i = bucket.length -1; i >= 1; i--){
            if(bucket[i] != null){
                
                for(int num : bucket[i]){
                    ans[index++] = num;

                    if(index == k){
                        return ans;
                    }
                }

               
            }
        }
        return ans;



        
    }
}