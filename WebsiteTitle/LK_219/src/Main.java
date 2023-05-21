import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User:${USER}
 * Date:${YEAR}-${MONTH}-${DAY}
 * Time:${TIME}
 */

class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(map.containsKey(nums[i])){
                //包含当前数值
                if(Math.abs(i-map.get(nums[i]))<=k){
                    //满足题意
                    return true;
                }else{
                    map.put(nums[i],i);
                }
            }else{
                //不包含 直接存入
                map.put(nums[i],i);
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