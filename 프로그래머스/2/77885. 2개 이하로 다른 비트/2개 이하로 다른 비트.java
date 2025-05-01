import java.util.*;

class Solution {
    Long ZERO = 0L;
    Long ONE = 1L;
    
    public long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];
        
        for(int i = 0; i < numbers.length; i++) answer[i] = f(numbers[i]);
        return answer;
    }
    
    long f(long x){
        List<Long> now = binary(x);
        
        if(now.contains(ZERO)){
            if(now.get(0) == ZERO) now.set(0, ONE);
            else{
                for(int i = 1; i < now.size(); i++){
                    if(now.get(i) == ONE) continue;
                    
                    now.set(i, ONE);
                    now.set(i - 1, ZERO);
                    break;
                }
            }    
        }else{
            now.add(ONE);
            if(0 < now.size() - 1) now.set(now.size() - 2, ZERO);
        }
        return decimal(now);
    }
    
    long decimal(List<Long> number){
        long ans = 0;
        for(int i = 0; i < number.size(); i++) ans += number.get(i) * Math.pow(2, i);
        
        return ans;
    }
    
    List<Long> binary(long number){
        List<Long> now = new ArrayList<>();
        
        while(0 < number){
            now.add(number % 2);
            number /= 2; 
        }
        return now;
    }
}