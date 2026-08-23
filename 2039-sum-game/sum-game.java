class Solution {
    public boolean sumGame(String num) {

        int n = num.length();
        int half = n / 2;

        int leftSum = 0;
        int rightSum = 0;

        int leftQ = 0;
        int rightQ = 0;

        // First half
        for (int i = 0; i < half; i++) {
            char c = num.charAt(i);

            if (c == '?') {
                leftQ++;
            } else {
                leftSum += c - '0';
            }
        }

        // Second half
        for (int i = half; i < n; i++) {
            char c = num.charAt(i);

            if (c == '?') {
                rightQ++;
            } else {
                rightSum += c - '0';
            }
        }

        int sumDiff = leftSum - rightSum;
        int questionDiff = leftQ - rightQ;

        /*
         * Bob can win only when the existing difference
         * can be exactly cancelled by the '?' characters.
         *
         * Each pair of extra '?' contributes 9/2.
         *
         * Therefore:
         *
         * 2 * sumDiff == -9 * questionDiff
         *
         * If this is true -> Bob wins -> false
         * Otherwise       -> Alice wins -> true
         */
        return 2 * sumDiff != -9 * questionDiff;
    }
}