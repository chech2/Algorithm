import java.util.*;

class Solution {
    int n, minLen;
    int[] gems;
    Map<String, Integer> types;
    Map<String, Integer> cnt;
    public int[] solution(String[] gems) {
        int[] answer = new int[] {1, 1};
        
        preSetting(gems);
        if(types.size() != 1) answer = findSection(gems);
        
        return answer;
    }
    
    int[] findSection(String[] gems){
        int[] answer = new int[2];
        int l, r;
        
        l = 0;
        r = 1;
        cnt.put(gems[l], 1);
        while(l <= r & r < n){
            // System.out.println(l + " " + gems[l] + " " + r + " " + gems[r]);
           
            if(gems[l].equals(gems[r])) { 
                l += remove(gems[l]);
                // System.out.println("    삭제:" + l + " " + gems[l] + " " + r + " " + gems[r]);
                                
                while(l < r - 1){
                    if(1 < cnt.get(gems[l])){
                    // System.out.println("   연속 삭제:" + l + " " + gems[l] + " " + r + " " + gems[r]);

                     l += remove(gems[l]);
                    }else break;
                }
            }
            cnt.put(gems[r], cnt.getOrDefault(gems[r], 0) + 1);
            
            if(types.size() <= cnt.size() && r - l + 1 < minLen){
                minLen = r - l + 1;
                answer[0] = l + 1;
                answer[1] = r + 1;
            }
            r++;            
        }

        return answer;
    }
    
    int remove(String l){
        if(cnt.get(l) == 1) cnt.remove(l);
        else cnt.put(l, cnt.get(l) - 1);
        
        return 1;
    }
    
    void preSetting(String[] gems){
        n = gems.length;
        minLen = n + 1;
        cnt = new HashMap<>();
        types = new HashMap<>();
        
        int idx = 1;
        for(int i = 0; i < n; i++) {
            if(!types.containsKey(gems[i])) types.put(gems[i], idx++);
        }
    }
}