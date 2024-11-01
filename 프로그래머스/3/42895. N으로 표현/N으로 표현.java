import java.util.*;

class Solution {
    int n, number, ans, size;
    Map<Integer, Integer> rot_n;
    
    public int solution(int N, int number) {
        pre_setting(N, number);
        
        for(Map.Entry<Integer, Integer> now : rot_n.entrySet()){
            recur(now.getValue(), now.getKey());
        }
        if(ans == 9) return -1;
        return ans;
    }
    
    void recur(int cnt, int num){
        if(8 < cnt) return;
        if(num == number){
            ans = Math.min(ans, cnt);
            return;
        }
        
        for(Map.Entry<Integer, Integer> now : rot_n.entrySet()){
            recur(cnt + now.getValue(), num - now.getKey());
            recur(cnt + now.getValue(), num + now.getKey());
            recur(cnt + now.getValue(), num / now.getKey());
            recur(cnt + now.getValue(), num * now.getKey());
        }
    }
    
    void pre_setting(int N, int number){
        
        this.n = N;
        this.number = number;
        this.ans = 9;
        this.size = String.valueOf(number).length() + 1;
        rot_n = new HashMap<>();
        
        int rot = 0;
        for(int i = 0; i <= size; i++){
            rot += Math.pow(10, i);
            rot_n.put((rot * n), (i + 1));
        }
        if(n != 1) rot_n.put(1, 2);
    }
}