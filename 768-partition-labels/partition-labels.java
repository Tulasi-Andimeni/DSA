class Solution {
    public List<Integer> partitionLabels(String s) {
      
        int[] Last = new int[26];
        for(int i = 0; i < s.length(); i++){

            Last[s.charAt(i) - 'a'] = i;

        }
        List< Integer> result = new ArrayList<>();
        int start = 0, end = 0;

        for(int i = 0; i < s.length(); i++){
            end = Math.max(end, Last[s.charAt(i) - 'a']);

            if(end == i){
                result.add(i - start + 1);
                start= i+1;
            }
        }
        return result;

    }
}