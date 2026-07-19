import java.util.*;

class Solution {
    
    public int solution(int[][] routes) {
        int answer = 0;
        int jump, r, l, nr, nl;
        
        Arrays.sort(routes, (o1, o2) -> {
            return o2[1] - o1[1];
        });
        
        for(int now = 0; now < routes.length; now++) {
            
            jump = 0;
            l = routes[now][0];
            r = routes[now][1];

            for(int next = now + 1; next < routes.length; next++){
                
                nl = routes[next][0];
                nr = routes[next][1];
                
                if(nr < l) break;
                if(l <= nl && nr <= r) l = nl;
                
                r = nr;
                jump++;
            }

            now += jump;
            answer++;
        }
        
        return answer;
    } 
}