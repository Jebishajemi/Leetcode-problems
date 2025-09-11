class Solution {
    public int[] plusOne(int[] digits) {
        int n = digits.length;

        // Step 1: loop from last digit to first
        for (int i = n - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                // Case 1: digit < 9 → just add 1, done
                digits[i]++;
                return digits;
            }
            // Case 2: digit == 9 → becomes 0, carry continues left
            digits[i] = 0;
        }

        // Step 2: if all digits were 9 → new array needed
        int[] result = new int[n + 1];
        result[0] = 1;  // e.g. 999 → 1000
        return result;
    }
}
