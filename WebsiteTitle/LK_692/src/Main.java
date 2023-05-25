import java.util.*;


/**
 * Created with IntelliJ IDEA.
 * Description:
 * User:${USER}
 * Date:${YEAR}-${MONTH}-${DAY}
 * Time:${TIME}
 */
class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String,Integer> map = new HashMap<>();
        //记录每个单词的频率
        //将单词和频率放到map中
        //遍历数组
        for(int i=0;i<words.length;i++){
            if(map.containsKey(words[i])){
                //包含该字符串
                //频率+1
                int num = map.get(words[i]);
                map.remove(words[i]);
                map.put(words[i],num+1);
            }else{
                //不包含该字符串
                map.put(words[i],1);
            }
        }

        //建立小根堆+比较器
        PriorityQueue<Map.Entry<String,Integer>> priority = new PriorityQueue<>(
                new Comparator<Map.Entry<String,Integer>>(){
                    public int compare(Map.Entry<String,Integer> o1,
                                       Map.Entry<String,Integer> o2){
                        //字母顺序的比较
                        if(o1.getValue() == o2.getValue()){
                            return o2.getKey().compareTo(o1.getKey());
                        }
                        //频率的比较
                        return o1.getValue() - o2.getValue();
                    }
                });

        //遍历map
        //放置小根堆中
        for(Map.Entry<String,Integer> entry:map.entrySet()){
            if(k>0){
                k--;
                priority.offer(entry);
            }else{
                if(priority.comparator().compare(priority.peek(), entry) < 0){
                    priority.poll();
                    priority.offer(entry);
                }
            }
        }

        List<String> list = new LinkedList<>();
        //集合逆序
        while(!priority.isEmpty()){
            list.add(priority.poll().getKey());
        }
        Collections.reverse(list);
        return list;
    }
}