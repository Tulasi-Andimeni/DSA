
class Solution {
    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {

        int n = nums1.length;
        long[] diff = new long[n];

        long total = 0;
        long maxDiff = 0;

        for (int i = 0; i < n; i++) {
            diff[i] = Math.abs((long) nums1[i] - nums2[i]);
            total += diff[i];
            maxDiff = Math.max(maxDiff, diff[i]);
        }

        long k = (long) k1 + k2;

        if (total <= k) {
            return 0;
        }

        // Binary search for the minimum possible maximum difference
        long low = 0;
        long high = maxDiff;

        while (low < high) {
            long mid = low + (high - low) / 2;
            long operations = 0;

            for (long d : diff) {
                if (d > mid) {
                    operations += d - mid;
                }
            }

            if (operations <= k) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        long limit = low;
        long used = 0;

        // Reduce all differences greater than limit
        for (int i = 0; i < n; i++) {
            if (diff[i] > limit) {
                used += diff[i] - limit;
                diff[i] = limit;
            }
        }

        // Use remaining operations to reduce limit by one
        long remaining = k - used;

        for (int i = 0; i < n && remaining > 0; i++) {
            if (diff[i] == limit && limit > 0) {
                diff[i]--;
                remaining--;
            }
        }

        long answer = 0;

        for (long d : diff) {
            answer += d * d;
        }

        return answer;
    }
}
