class Solution {
    public static boolean isMonotonic(int[] nums) {
        boolean inc=true;
        boolean dec=true;
        for(int i=0;i<nums.length-1;i++){
            if(nums[i]<nums[i+1]){
                dec=false;
            }
            if(nums[i]>nums[i+1]){
                 inc=false;
            }
        }
        return inc||dec;
    }
    public static void main(String[]args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int nums[]=new int[n];
        for(int i=0;i<n;i++){
            nums[i]=sc.nextInt();
        }
        boolean isMonotonic = isMonotonic(nums);
        
            System.out.println(isMonotonic ? "true" : "false");
       
    }
}