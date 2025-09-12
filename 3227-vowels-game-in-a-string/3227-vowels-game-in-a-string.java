class Solution {
    public boolean doesAliceWin(String s) {
        for (char c : s.toCharArray()) {
            if ("aeiou".indexOf(c) != -1) {
                return true;  // At least one vowel → Alice wins
            }
        }
        return false;  // No vowels → Alice cannot move
    }
}
