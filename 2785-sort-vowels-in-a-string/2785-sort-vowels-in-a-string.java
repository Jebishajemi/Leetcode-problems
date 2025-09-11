class Solution {
    public String sortVowels(String s) {
        String vowels = "aeiouAEIOU";
        char[] a = s.toCharArray();

        List<Character> v = new ArrayList<>();
        for (char c : a)
            if (vowels.indexOf(c) >= 0) v.add(c);   // collect vowels only

        Collections.sort(v);                        // sort by ASCII

        int k = 0;
        for (int i = 0; i < a.length; i++)
            if (vowels.indexOf(a[i]) >= 0)          // replace only vowels
                a[i] = v.get(k++);

        return new String(a);
    }
}
