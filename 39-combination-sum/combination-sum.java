class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();

        generate(candidates, target, 0 , result, curr);
        return result;
        
    }

    private void generate(int[] candidates, int target, int index, List<List<Integer>> result, List<Integer> curr){

        if(target == 0){
            result.add(new ArrayList<>(curr));
            return;
        }
        if(target < 0){
            return;
        }

        for(int i = index; i < candidates.length; i++){
            curr.add(candidates[i]);
            generate(candidates, target - candidates[i], i, result, curr);
            curr.remove(curr.size() - 1);
        }
    }
}