class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] result = {-1, -1};
        int left = 0, right = nums.length - 1;

        // find first position
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] >= target) right = mid - 1;
            else left = mid + 1;
            if (left < nums.length && nums[left] == target) result[0] = left;
        }

        left = 0; right = nums.length - 1;

        // find last position
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] <= target) left = mid + 1;
            else right = mid - 1;
            if (right >= 0 && nums[right] == target) result[1] = right;
        }

        return result;
    }
}
