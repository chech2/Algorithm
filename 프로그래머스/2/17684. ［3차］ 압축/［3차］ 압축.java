import java.util.*;
/*
    글자가 있어
        1. 현 글자와 다음 글자를 합쳐
        2. 합친 글자가 없어.
        3. 현 글자 색인 출력
        4. '현 글자 + 다음 글자'사전 추가
    글자가 없어.
        
        
*/

class Solution {
    
    char[] strs;
    HashMap<String, Integer> map = new HashMap<String, Integer>();
    List<Integer> answer = new ArrayList<>();
    public int[] solution(String msg) {    
        preSetting();
        strs = msg.toCharArray();
        
        for(int i = 0; i < strs.length; i++){
            i = find(i);
        }
        
        return answer.stream().mapToInt(i -> i).toArray();
    }
    
    int find(int idx){
        int ans = 0;
        String now = "";
        
        for(; idx < strs.length; idx++){
            now += strs[idx];
            
            if(map.containsKey(now)){
                ans = map.get(now);
            }else{
                map.put(now, map.size() + 1);
                break;
            }
        }
        // System.out.println(now + " " + ans + " : " + idx);
        answer.add(ans);
        return idx - 1;
    }
    
    
    
    void preSetting(){
        String[] w = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".split("");
        for(int i = 1; i < 27; i++){
            map.put(w[i - 1], i);
        }        
    }
}



/*
for(Map.Entry<String, Integer> test: map.entrySet()){
            System.out.println(test.getValue() + " " + test.getKey());
        }
        

*/