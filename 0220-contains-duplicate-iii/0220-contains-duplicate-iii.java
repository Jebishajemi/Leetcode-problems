import java.util.*;

class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int indexDiff, int valueDiff) {
        TreeSet<Long> set = new TreeSet<>();
        
        for (int i = 0; i < nums.length; i++) {
            Long floor = set.floor((long)nums[i] + valueDiff);   // largest ≤ nums[i]+valueDiff
            Long ceil = set.ceiling((long)nums[i] - valueDiff); // smallest ≥ nums[i]-valueDiff
            
            if ((floor != null && floor >= nums[i]) || (ceil != null && ceil <= nums[i])) {
                return true;
            }
            
            set.add((long)nums[i]);
            
            if (i >= indexDiff) {
                set.remove((long)nums[i - indexDiff]); // maintain window size
            }
        }
        
        return false;
    }
}
