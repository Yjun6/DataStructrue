import java.util.*;

public class Solution {
    public boolean IsPopOrder(int [] pushA,int [] popA) {
        if(pushA == null && popA == null){
            return true;
        }
        if(popA==null){
            return false;
        }
        if(pushA==null){
            return false;
        }
        //判断
        Stack<Integer> s = new Stack<>();
        int i = 0, j = 0;
        while(i < pushA.length){
            if(pushA[i] == popA[j]){
                j++;
                i++;
            }else if(!s.empty()){
                if(s.peek() == popA[j]){
                    s.pop();
                    j++;
                }else{
                    s.add(pushA[i]);
                    i++;
                }
            }else{
                s.add(pushA[i]);
                i++;
            }
        }
        while(!s.empty() && j < popA.length){
            if(s.peek() == popA[j]){
                s.pop();
                j++;
            }else{
                return false;
            }
        }
        if(!s.empty()){
            return false;
        }
        if(j<popA.length){
            return false;
        }
        return true;

    }
}