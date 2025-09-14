class Solution {
    public String[] spellchecker(String[] wordlist, String[] queries) {
        Set<String> exact = new HashSet<>();
        Map<String, String> lowerMap = new HashMap<>();
        Map<String, String> vowelMap = new HashMap<>();

        for (String word : wordlist) {
            exact.add(word);
            String lower = word.toLowerCase();
            lowerMap.putIfAbsent(lower, word);
            vowelMap.putIfAbsent(normalize(lower), word);
        }

        String[] res = new String[queries.length];
        for (int i = 0; i < queries.length; i++) {
            String q = queries[i];
            if (exact.contains(q)) {
                res[i] = q;
            } else {
                String lower = q.toLowerCase();
                if (lowerMap.containsKey(lower)) {
                    res[i] = lowerMap.get(lower);
                } else {
                    res[i] = vowelMap.getOrDefault(normalize(lower), "");
                }
            }
        }
        return res;
    }

    private String normalize(String word) {
        return word.replaceAll("[aeiou]", "*");
    }
}
