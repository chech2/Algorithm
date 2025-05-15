import java.util.*;

class Solution {
    int n;
    long[] plus, minus;
    public long solution(int[] sequence) {
        n = sequence.length;
        plus = new long[n + 1];
        minus = new long[n + 1];
        
        long answer = findMax(sequence);
        return answer;
    }
    
    long findMax(int[] sequence){
        long answer = -50000000000L;
        int pulse, now;
        
        pulse = 1;
        for(int i = 1; i < n + 1; i++){
            now = sequence[i - 1] * pulse;
            plus[i] = Math.max(plus[i - 1] + now, now);
            
            now *= -1;
            minus[i] = Math.max(minus[i - 1] + now, now); 
            
            answer = Math.max(plus[i], Math.max(answer, minus[i]));
            pulse *= -1;
        }
    
        return answer;
    }
}