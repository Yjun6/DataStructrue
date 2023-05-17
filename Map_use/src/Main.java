import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User:${USER}
 * Date:${YEAR}-${MONTH}-${DAY}
 * Time:${TIME}
 */

public class Main {
    public static void main(String[] args) {
        Map<String, Integer> map = new TreeMap<>();
        map.put("aaa",3);
        map.put("bbb",4);
        map.put("aaa",5);
        map.put("aaab",5);
        map.put("aaas",5);
        map.put("aaaq",5);

        System.out.println(map.get("aaa"));
        map.remove("aaa");
        System.out.println(map.getOrDefault("aaa", 0));
        Set<String> set1 = map.keySet();

        //遍历Map
        Set<Map.Entry<String,Integer>> entry1 = map.entrySet();
        for (Map.Entry<String,Integer> entry:entry1) {
            System.out.println("key:"+entry.getKey()+
                            " value:"+entry.getValue());
        }

    }
}