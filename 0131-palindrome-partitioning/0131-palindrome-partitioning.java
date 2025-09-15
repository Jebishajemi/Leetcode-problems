import java.util.*;

class Solution {
    List<List<String>> res = new ArrayList<>();
    
    public List<List<String>> partition(String s) {
        backtrack(s, 0, new ArrayList<>());
        return res;
    }

    private void backtrack(String s, int start, List<String> curr) {
        if (start == s.length()) {
            res.add(new ArrayList<>(curr));
            return;
        }
        for (int end = start; end < s.length(); end++) {
            if (isPalindrome(s, start, end)) {
                curr.add(s.substring(start, end + 1));
                backtrack(s, end + 1, curr);
                curr.remove(curr.size() - 1);
            }
        }
    }

    private boolean isPalindrome(String s, int i, int j) {
        while (i < j) {
            if (s.charAt(i++) != s.charAt(j--)) return false;
        }
        return true;
    }
}
