class Solution {
    public int firstMissingPositive(int[] nums) {
        Set<Integer>List=new HashSet<>();
        for(int num:nums){
            if(num>0){
            List.add(num);
        }
    }
        for(int i=1;i<=List.size()+1;i++){
            if(!List.contains(i)){
                return i;
            }
        }
        return -1;
    }
}