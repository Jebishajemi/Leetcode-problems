class Solution {
    public int minimumTeachings(int n, int[][] languages, int[][] friendships) {
        Set<Integer> needTeach = new HashSet<>();
        // Identify friends who cannot communicate
        for (int[] f : friendships) {
            int u = f[0], v = f[1];
            if (!canCommunicate(u, v, languages)) {
                needTeach.add(u);
                needTeach.add(v);
            }
        }
        // If everyone can already communicate, no teaching needed
        if (needTeach.isEmpty()) return 0;

        // Count how many users in 'needTeach' know each language
        int[] count = new int[n + 1];
        for (int u : needTeach) {
            for (int lang : languages[u - 1]) {
                count[lang]++;
            }
        }

        // Choose the language with the highest coverage
        int maxKnown = 0;
        for (int lang = 1; lang <= n; lang++) {
            maxKnown = Math.max(maxKnown, count[lang]);
        }

        // Teach that language to everyone in 'needTeach' who doesn't know it
        return needTeach.size() - maxKnown;
    }

    private boolean canCommunicate(int u, int v, int[][] languages) {
        for (int langU : languages[u - 1]) {
            for (int langV : languages[v - 1]) {
                if (langU == langV) return true;
            }
        }
        return false;
    }
}