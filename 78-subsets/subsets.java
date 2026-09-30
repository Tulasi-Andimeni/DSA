class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();

        generate(nums, 0 , curr, result);
        return result;
        
    }

    private void generate(int[] nums, int index, List<Integer> curr,  List<List<Integer>> result){

        if(index == nums.length){
            result.add(new ArrayList<>(curr));
            return;
        }

        curr.add(nums[index]);
        generate(nums, index +1, curr, result);

        curr.remove(curr.size() - 1);
        generate(nums, index + 1, curr, result);
    }
}