class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        int[] freq = new int[nums.length +1];

        freq[0] = 1;

        int oddcount = 0, count = 0;

        for(int num : nums){

            if(num % 2 != 0){
                oddcount++;
            }

            if(oddcount >= k){
                count += freq[oddcount - k];
            }

            freq[oddcount]++;
        }
        return count;
    }
}