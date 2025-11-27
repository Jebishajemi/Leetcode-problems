class Solution {
    public long maxSubarraySum(int[] nums, int k) {

        long[] best = new long[k];
        // Initialize best[] to +∞ except best[0] = 0 (prefix before index 0)
        for (int i = 0; i < k; i++) best[i] = Long.MAX_VALUE;
        best[0] = 0;

        long prefix = 0;
        long res = Long.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {
            prefix += nums[i];

            int r = (i + 1) % k;   // prefix index is i+1

            // Use best[r] if we've seen any prefix with same index%k
            if (best[r] != Long.MAX_VALUE) {
                res = Math.max(res, prefix - best[r]);
            }

            // Update best for this remainder
            best[r] = Math.min(best[r], prefix);
        }

        return res;
    }
}
