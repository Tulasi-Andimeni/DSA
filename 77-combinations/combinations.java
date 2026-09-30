class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();

        generate(1, n , k , curr, result);
        return result;
    }
    private void generate(int start, int n, int k , List<Integer> curr, List<List<Integer>> result){
        if(curr.size() == k){
            result.add(new ArrayList<>(curr));
            return;
        }

        for(int i = start; i <= n; i++){
            curr.add(i);
            generate(i+1, n, k, curr, result);

            curr.remove(curr.size() -1);
        }
    }
}