class Solution {
    public int countDigitOne(int n) {
        long digit = 1, res = 0;
        long low = 0, high = n, cur;
        
        while (high > 0) {
            cur = high % 10;
            high /= 10;
            
            res += high * digit;
            
            if (cur == 1) {
                res += low + 1;
            } else if (cur > 1) {
                res += digit;
            }
            
            low += cur * digit;
            digit *= 10;
        }
        
        return (int)res;
    }
}
