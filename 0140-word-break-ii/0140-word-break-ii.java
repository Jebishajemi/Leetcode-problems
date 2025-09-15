import java.util.*;

class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        Set<String> wordSet = new HashSet<>(wordDict); // fast lookup
        Map<String, List<String>> memo = new HashMap<>(); // memoization map
        return backtrack(s, wordSet, memo);
    }

    private List<String> backtrack(String s, Set<String> wordSet, Map<String, List<String>> memo) {
        if (memo.containsKey(s)) return memo.get(s);
        List<String> res = new ArrayList<>();
        
        if (s.length() == 0) {
            res.add("");  // base case: empty string means valid break
            return res;
        }

        for (int i = 1; i <= s.length(); i++) {
            String prefix = s.substring(0, i);
            if (wordSet.contains(prefix)) {
                List<String> suffixWays = backtrack(s.substring(i), wordSet, memo);
                for (String suffix : suffixWays) {
                    String space = suffix.isEmpty() ? "" : " ";
                    res.add(prefix + space + suffix);
                }
            }
        }

        memo.put(s, res);
        return res;
    }
}
