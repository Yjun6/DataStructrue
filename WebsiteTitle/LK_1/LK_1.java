class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] num = new int[2];
        for(int i=0;i<nums.length;i++){
            boolean f = false;
            for(int j=1;j<nums.length;j++){
                if(nums[i] + nums[j] == target && i != j){
                    num[0] = i;
                    num[1] = j;
                    f = true;
                    break;
                }
            }
            if(f)
                break;
        }
         return num;
    }
   
}