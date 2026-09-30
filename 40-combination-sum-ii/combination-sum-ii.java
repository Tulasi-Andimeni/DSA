class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        Arrays.sort(candidates);
        generate(candidates, target, 0, result, curr);
        return result;
    }

    private void generate(int[] candidates, int target, int start, List<List<Integer>> result, List<Integer> curr){
        if(target == 0){
            result.add(new ArrayList<>(curr));
            return;
        }
        for(int i = start; i< candidates.length; i++){

            if(i > start && candidates[i] == candidates[i-1]){
                continue;
            }
            if(candidates[i] > target){
                break;
            }

            curr.add(candidates[i]);
            generate(candidates, target-candidates[i], i+1, result, curr);

            curr.remove(curr.size() - 1);
        }
    }
}