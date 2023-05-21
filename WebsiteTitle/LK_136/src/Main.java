/**
 * Created with IntelliJ IDEA.
 * Description:
 * User:${USER}
 * Date:${YEAR}-${MONTH}-${DAY}
 * Time:${TIME}
 */
class Solution {
    public int singleNumber(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int i=0;i<nums.length;i++){
            if(set.contains(nums[i])){
                set.remove(nums[i]);
            }else{
                set.add(nums[i]);
            }
        }
        Object[] arr = set.toArray();
        int a = Integer.parseInt(arr[0].toString());
        return a;
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }
}