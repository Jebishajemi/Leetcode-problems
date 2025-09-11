class Solution {
    public int mySqrt(int x) {
    
    if (x < 2) return x;

    int left = 1, right = x, ans = 0;

    while (left <= right) {
        int mid = left + (right - left) / 2;

        // Use long to prevent overflow for mid * mid
        long sq = (long) mid * mid;

        if (sq == x) return mid;
        else if (sq < x) {
            ans = mid;       // mid might be the floor sqrt
            left = mid + 1;
        } else {
            right = mid - 1;
        }
    }

    return ans;


    }
}