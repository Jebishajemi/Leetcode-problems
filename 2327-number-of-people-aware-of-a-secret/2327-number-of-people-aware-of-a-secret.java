class Solution {
    public int peopleAwareOfSecret(int n, int delay, int forget) {
        int mod = 1_000_000_007;
        long[] dp = new long[n + 1]; // dp[i] = people who learn secret on day i
        dp[1] = 1;
        long share = 0; // running count of people who can share

        for (int day = 2; day <= n; day++) {
            // people start sharing after 'delay' days
            if (day - delay >= 1) share = (share + dp[day - delay]) % mod;
            // people forget after 'forget' days
            if (day - forget >= 1) share = (share - dp[day - forget] + mod) % mod;

            dp[day] = share; // new people who learn today
        }

        long ans = 0;
        // count people who still remember at day n
        for (int day = n - forget + 1; day <= n; day++) {
            if (day >= 1) ans = (ans + dp[day]) % mod;
        }
        return (int) ans;
    }
}
