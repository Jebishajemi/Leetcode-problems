class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> res = new ArrayList<>();
        int i = 0;

        while (i < words.length) {
            int j = i + 1;
            int lineLen = words[i].length();

            // Greedily take words that fit
            while (j < words.length && lineLen + 1 + words[j].length() <= maxWidth) {
                lineLen += 1 + words[j].length(); // 1 for space
                j++;
            }

            StringBuilder line = new StringBuilder();
            int numWords = j - i;
            int gaps = numWords - 1;

            // CASE 1: Last line OR single word → left justify
            if (j == words.length || gaps == 0) {
                // add words with single space
                for (int k = i; k < j; k++) {
                    line.append(words[k]);
                    if (k < j - 1) line.append(" ");
                }

                // fill remaining spaces at end
                while (line.length() < maxWidth) line.append(' ');

            } else {
                // CASE 2: Fully justify
                int totalSpaces = maxWidth;

                // subtract words' letters
                for (int k = i; k < j; k++) {
                    totalSpaces -= words[k].length();
                }

                int spaceEach = totalSpaces / gaps;
                int extra = totalSpaces % gaps; // first "extra" gaps get +1 space

                for (int k = i; k < j - 1; k++) {
                    line.append(words[k]);

                    // normal spaces
                    for (int s = 0; s < spaceEach; s++) line.append(' ');

                    // extra space for leftmost gaps
                    if (extra > 0) {
                        line.append(' ');
                        extra--;
                    }
                }

                // last word (no extra spaces)
                line.append(words[j - 1]);
            }

            res.add(line.toString());
            i = j; // move to next line
        }

        return res;
    }
}
