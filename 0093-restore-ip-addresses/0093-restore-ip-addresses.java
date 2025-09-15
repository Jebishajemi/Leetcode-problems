import java.util.*;

class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        backtrack(s, 0, "", 0, res);
        return res;
    }
    
    private void backtrack(String s, int index, String path, int count, List<String> res) {
        if (count > 4) return; // too many segments
        if (index == s.length() && count == 4) {
            res.add(path.substring(0, path.length() - 1)); // remove trailing dot
            return;
        }
        
        for (int len = 1; len <= 3 && index + len <= s.length(); len++) {
            String seg = s.substring(index, index + len);
            if ((seg.startsWith("0") && seg.length() > 1) || Integer.parseInt(seg) > 255) continue;
            backtrack(s, index + len, path + seg + ".", count + 1, res);
        }
    }
}
