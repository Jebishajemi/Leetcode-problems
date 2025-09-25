import java.util.*;

public class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList); // For fast lookup
        if (!wordSet.contains(endWord)) return 0;

        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        int level = 1;

        while (!queue.isEmpty()) {
            int size = queue.size();

            // Process all words at current level
            for (int i = 0; i < size; i++) {
                String word = queue.poll();

                // Try changing each letter
                for (int j = 0; j < word.length(); j++) {
                    char[] chars = word.toCharArray();

                    for (char c = 'a'; c <= 'z'; c++) {
                        chars[j] = c;
                        String newWord = new String(chars);

                        // Check if we've reached the end
                        if (newWord.equals(endWord)) {
                            return level + 1;
                        }

                        // If valid intermediate word
                        if (wordSet.contains(newWord)) {
                            queue.offer(newWord);
                            wordSet.remove(newWord); // mark as visited
                        }
                    }
                }
            }

            level++; // Next transformation step
        }

        return 0; // No valid transformation
    }
}
