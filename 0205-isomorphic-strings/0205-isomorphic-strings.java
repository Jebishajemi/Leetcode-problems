import java.util.*;

class Solution {
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) return false;
        
        Map<Character, Character> mapST = new HashMap<>();
        Map<Character, Character> mapTS = new HashMap<>();
        
        for (int i = 0; i < s.length(); i++) {
            char cs = s.charAt(i);
            char ct = t.charAt(i);
            
            if ((mapST.containsKey(cs) && mapST.get(cs) != ct) ||
                (mapTS.containsKey(ct) && mapTS.get(ct) != cs)) {
                return false;
            }
            
            mapST.put(cs, ct);
            mapTS.put(ct, cs);
        }
        
        return true;
    }
}
