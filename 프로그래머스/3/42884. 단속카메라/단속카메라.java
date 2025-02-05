import java.util.*;

class Solution {
    
    public int solution(int[][] routes) {
        int answer = 0;
        int jump, r, l, nr, nl;
        
        Arrays.sort(routes, (o1, o2) -> {
            return o2[1] - o1[1];
        });
        
        // for(int now = 0; now < routes.length; now++) System.out.println(Arrays.toString(routes[now]));

        
        for(int now = 0; now < routes.length; now++) {
            
            jump = 0;
            l = routes[now][0];
            r = routes[now][1];
            // System.out.println(now + "번 " + l + " " + r);
            for(int next = now + 1; next < routes.length; next++){
                
                nl = routes[next][0];
                nr = routes[next][1];
                
                if(l <= nl && nr <= r){
                    l = nl;
                    r = nr;
                    jump++; 
                    
                } else if(l <= nr){
                    r = nr;
                    jump++;
                    
                } else break;
            }
            // System.out.println("      " + l + " " + r);

            now += jump;
            answer++;
        }
        
        return answer;
    } 
}