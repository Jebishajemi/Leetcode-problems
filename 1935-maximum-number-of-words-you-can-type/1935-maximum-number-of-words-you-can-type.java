class Solution {
    public int canBeTypedWords(String text, String brokenLetters) {
        String[] words = text.split(" ");
        int count = 0;
        for (String word : words) {
            if (!containsBrokenLetter(word, brokenLetters)) {
                count++;
            }
        }
        return count;
    }

    private boolean containsBrokenLetter(String word, String brokenLetters) {
        for (char c : brokenLetters.toCharArray()) {
            if (word.indexOf(c) != -1) return true;
        }
        return false;
    }
}
