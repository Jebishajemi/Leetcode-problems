import java.util.*;

class Solution {
    public int romanToInt(String s) {
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        
        int result = 0;
        int n = s.length();
        
        for (int i = 0; i < n; i++) {
            int value = map.get(s.charAt(i));
            // Look ahead to next symbol if any
            if (i < n - 1 && value < map.get(s.charAt(i + 1))) {
                // Subtractive case
                result -= value;
            } else {
                // Additive case
                result += value;
            }
        }
        
        return result;
    }
}
