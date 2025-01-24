import java.util.*;

class Solution {
    int[][] targets;
    
    public int solution(int[][] targets) {
        pre_setting(targets);
        return hit(targets.length);
    }
    
    private int hit(int missile) {
        int x = 0;
        int cnt = 0;
        for(int i = 0; i < missile; i++){
            if(x <= targets[i][0]){
                x = targets[i][1];
                cnt++;
            }
        }

        return cnt;
    }
    
    private void pre_setting(int[][] targets) {
        this.targets = targets;
        
        Arrays.sort(targets, (o1, o2) -> {
            if(o1[1] == o2[1]) return o1[0] - o2[0];
            return o1[1] - o2[1];
        });    
        
    }
    
}