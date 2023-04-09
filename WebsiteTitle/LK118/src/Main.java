import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User:${USER}
 * Date:${YEAR}-${MONTH}-${DAY}
 * Time:${TIME}
 */
//题解
class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> list = new ArrayList<>();

        for(int i = 0; i < numRows; i++){
            List<Integer> list1 = new ArrayList<>();
            if(i == 0){
                list1.add(1);
            }else{
                list1.add(1);
                for(int j = 1; j < i; j++){
                    Integer num = list.get(i-1).get(j-1)+list.get(i-1).get(j);
                    list1.add(num);
                }
                list1.add(1);
            }

            list.add(list1);
        }

        return list;
    }
}
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.generate(3);
    }
}