class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character>c=new HashSet<>();
        int len=0;
        int left=0;
        for(int right=0;right<s.length();right++){
            char ch=s.charAt(right);
            while(c.contains(ch)){
                c.remove(s.charAt(left));
                left++;
                
            }
            c.add(ch);
            len=Math.max(len,right-left+1);
        }
        return len;
    }
}