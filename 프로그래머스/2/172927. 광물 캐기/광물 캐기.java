import java.util.*;

class Solution {
    Map<String, Integer> map;
    int[][] info;
    String[] minerals;
    int ans, stop;
    
    public int solution(int[] picks, String[] minerals) {
        int answer = 0;
        this.minerals = minerals;
        setting(picks);
        recur(0, picks, 0);
        
        return ans;
    }
    
    void setting(int[] picks){
        info = new int[][]{{1, 1, 1}, {5, 1, 1}, {25, 5, 1}};
        map = new HashMap<>();
        map.put("diamond", 0);
        map.put("iron", 1);
        map.put("stone", 2);
        
        ans = 5000;
        
        int pick = 0;
        for(int i = 0; i < 3; i++) pick += picks[i];
        
        stop = Math.min(pick * 5, minerals.length);
    }
    
    
    
    void recur(int cnt, int[] resource, int sum){
        if(stop <= cnt){
            System.out.println(sum);
            ans = Math.min(ans, sum);
            return;
        }
        
        int rot, j;
        for(int i = 0; i < 3; i++){
            if(resource[i] <= 0) continue;
            
            rot = 0;
            for(j = 0; j < 5; j++){
                
                if(stop <= cnt + j) break;
                rot += info[i][(int)map.get(minerals[cnt + j])];
            }    
            resource[i]--;
            recur(cnt + j, resource, sum + rot);
            resource[i]++;
        }
    }

}