import java.util.*;

class Solution {
    public int[] solution(int n, long k) {
        int[] answer = new int[n];
        List<Integer> numbers = new ArrayList<>();
        long factorial = 1;
        
        for (int i = 1; i <= n; i++) {
            numbers.add(i);
            if (i < n) {
                factorial *= i;
            }
        }
        
        k--; 
        
        int idx = 0;
        for (int i = 0; i < n; i++) {
            int selectedIndex = (int) (k / factorial);
            answer[idx++] = numbers.get(selectedIndex);
            numbers.remove(selectedIndex);
            
            k %= factorial;
            
            if (n - 1 - i > 0) {
                factorial /= (n - 1 - i);
            }
        }
        
        return answer;
    }
}