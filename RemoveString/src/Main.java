import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User:${USER}
 * Date:${YEAR}-${MONTH}-${DAY}
 * Time:${TIME}
 */
public class Main {
    public static void func(String s1, String s2){
        ArrayList<Character> arrayList = new ArrayList<>();
        for (int i = 0; i < s1.length(); i++) {
            arrayList.add(s1.charAt(i));
        }
        for (int i = 0; i < s2.length(); i++) {
            char arr = s2.charAt(i);
            while(arrayList.contains(arr)){
                arrayList.remove((Object)arr);
            }
        }
        System.out.println(arrayList);
        
    }
    public static void main(String[] args) {
        func("awuzdjf sdf", "afd");
    }
}