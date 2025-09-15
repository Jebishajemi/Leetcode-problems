class Solution {
    public int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            // If middle element is greater than or equal to left,
            // it means the smallest is in the right half
            if (nums[mid] >= nums[left]) {
                // If array is already sorted or rotated,
                // minimum will be after mid
                if (nums[left] < nums[right]) {
                    return nums[left]; // Already sorted segment
                }
                left = mid + 1;
            } else {
                // If nums[mid] < nums[left], minimum lies in left half (including mid)
                right = mid;
            }
        }
        return nums[left];
    }
}
