class Solution {
    public String lexGreaterPermutation(String s, String target) {
             int n = s.length();

        int[] count = new int[26];

        // Frequency of characters in s
        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }

        StringBuilder prefix = new StringBuilder();

        for (int i = 0; i < n; i++) {

            int t = target.charAt(i) - 'a';

            // Try same character first
            if (count[t] > 0) {
                prefix.append(target.charAt(i));
                count[t]--;
            } else {

                // Same character not available.
                // Try a character greater than target[i].
                for (int c = t + 1; c < 26; c++) {

                    if (count[c] > 0) {

                        StringBuilder ans = new StringBuilder(prefix);

                        ans.append((char) ('a' + c));
                        count[c]--;

                        // Append remaining characters in sorted order
                        for (int x = 0; x < 26; x++) {
                            while (count[x] > 0) {
                                ans.append((char) ('a' + x));
                                count[x]--;
                            }
                        }

                        return ans.toString();
                    }
                }

                // Current position cannot be made greater.
                // Now backtrack.
                break;
            }
        }

        /*
         * Backtrack from right to left.
         */
        for (int i = prefix.length() - 1; i >= 0; i--) {

            // Restore character used at position i
            int old = prefix.charAt(i) - 'a';
            count[old]++;

            int t = target.charAt(i) - 'a';

            // Find smallest character greater than target[i]
            for (int c = t + 1; c < 26; c++) {

                if (count[c] > 0) {

                    StringBuilder ans = new StringBuilder();

                    // Keep prefix before i
                    ans.append(prefix.substring(0, i));

                    // Put greater character
                    ans.append((char) ('a' + c));
                    count[c]--;

                    // Add remaining characters smallest first
                    for (int x = 0; x < 26; x++) {
                        while (count[x] > 0) {
                            ans.append((char) ('a' + x));
                            count[x]--;
                        }
                    }

                    return ans.toString();
                }
            }
        }

        return "";
        
    }
}