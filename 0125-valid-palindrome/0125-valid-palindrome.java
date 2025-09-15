class Solution {
    public boolean isPalindrome(String s) {
        // Remove all non-alphanumeric chars and convert to lowercase
        String clean = s.replaceAll("[^A-Za-z0-9]", "").toLowerCase();
        
        // Check if clean string is palindrome
        int n = clean.length();
        for (int i = 0; i < n / 2; i++) {
            if (clean.charAt(i) != clean.charAt(n - 1 - i)) {
                return false;
            }
        }
        return true;
    }
}
