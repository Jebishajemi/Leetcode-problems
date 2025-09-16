import java.util.*;

public class Solution {
    public List<Integer> replaceNonCoprimes(int[] nums) {
        Stack<Integer> stack = new Stack<>();

        for (int num : nums) {
            while (!stack.isEmpty() && gcd(stack.peek(), num) > 1) {
                int top = stack.pop();
                num = lcm(top, num);
            }
            stack.push(num);
        }

        return new ArrayList<>(stack);
    }

    private int gcd(int a, int b) {
        // Euclidean algorithm
        while (b != 0) {
            int temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }

    private int lcm(int a, int b) {
        // Compute LCM using GCD
        return a / gcd(a, b) * b;
    }
}
