
class Solution {
    public int[] beautifulArray(int n) {
        List<Integer> res = buildArray(n);
        return res.stream().mapToInt(i -> i).toArray();
    }
    
    private List<Integer> buildArray(int n) {
        if (n == 1) {
            return new ArrayList<>(Arrays.asList(1));
        }
        
        List<Integer> res = new ArrayList<>();
        
        // odds from beautifulArray((n + 1)/2)
        for (int x : buildArray((n + 1) / 2)) {
            res.add(2 * x - 1);
        }
        
        // evens from beautifulArray(n/2)
        for (int x : buildArray(n / 2)) {
            res.add(2 * x);
        }
        
        return res;
    }
}
