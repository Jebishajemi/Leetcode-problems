class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // Map key: sorted string, value: list of anagrams
        Map<String, List<String>> map = new HashMap<>();
        
        for (String s : strs) {
            // Convert string to char array, sort it, then convert back to string
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String sorted = new String(chars);
            
           
            map.computeIfAbsent(sorted, k -> new ArrayList<>()).add(s);
        }
        
        
        return new ArrayList<>(map.values());
    }
}