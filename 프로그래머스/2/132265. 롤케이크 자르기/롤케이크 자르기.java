import java.util.*;

class Solution {
    
    int answer, size;
    Map<Integer, Integer> me, bro;
    
    public int solution(int[] topping) {
        pre_setting(topping);
        
        int now;
        for(int i = 1; i < size - 1; i++){
            now = topping[i];
            if(me.containsKey(now)) me.put(now, me.get(now) + 1);
            else me.put(now, 1);
            
            if(bro.get(now) == 1) bro.remove(now);
            else bro.put(now, bro.get(now) - 1);
            
            if(me.size() == bro.size()) answer++;
        }
        return answer;
    }
    
    void pre_setting(int[] topping) {
        answer = 0;
        size = topping.length;
        
        me = new HashMap<>();
        bro = new HashMap<>();
        
        me.put(topping[0], 1);
        
        int now;
        for(int i = 1; i < size; i++){
            now = topping[i];
            if(bro.containsKey(now)) bro.put(now, bro.get(now) + 1);
            else bro.put(now, 1);
        }
       
    }

}