class Solution {
    public int[][] merge(int[][] intervals) {
        
         // Step 1: Sort by starting value
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        List<int[]> result = new ArrayList<>();

        // Step 2: First interval add cheyyali
        result.add(intervals[0]);

        // Step 3: Remaining intervals check cheyyali
        for (int i = 1; i < intervals.length; i++) {

            int[] current = intervals[i];
            int[] last = result.get(result.size() - 1);

            if (current[0] <= last[1]) {
                // Overlap: update ending value
                last[1] = Math.max(last[1], current[1]);
            } else {
                // No overlap: add new interval
                result.add(current);
            }
        }

        return result.toArray(new int[result.size()][]);
    }
}