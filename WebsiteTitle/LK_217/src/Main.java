/**
 * Created with IntelliJ IDEA.
 * Description:
 * User:${USER}
 * Date:${YEAR}-${MONTH}-${DAY}
 * Time:${TIME}
 */

class Solution {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        //遍历每一个数字，无重复保存起来
        for(int i=0;i<nums.length;i++){
            set.add(nums[i]);
        }
        //去set里面找，出现一次就删除，再次出现就返回true，否则false
        for(int i=0;i<nums.length;i++){
            if(set.contains(nums[i])){
                set.remove(nums[i]);
            }else{
                return true;
            }
        }
        return false;
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }
}