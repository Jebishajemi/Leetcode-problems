class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        int minLen = Integer.MAX_VALUE;
        int sum = 0, left = 0;

        for (int right = 0; right < n; right++) {
            sum += nums[right];

            // shrink the window from the left while sum >= target
            while (sum >= target) {
                minLen = Math.min(minLen, right - left + 1);
                sum -= nums[left++];
            }
        }

        return (minLen == Integer.MAX_VALUE) ? 0 : minLen;
    }
}
