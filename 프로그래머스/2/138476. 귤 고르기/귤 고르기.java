import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        Map<Integer, Integer> map = selectTangerine(tangerine);
        if(k == map.size()) return k;
        
        return findType(new ArrayList<>(map.entrySet()), k);
    }

    private int findType(List<Map.Entry<Integer, Integer>> list, int k){
        int result = 0;
        list.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));
        
        for(Map.Entry<Integer, Integer> entry : list){
            k-= entry.getValue();
            result++;
            
            if(k <= 0){   
                break;
            }
        }
        return result;
    }
    
    private Map<Integer, Integer> selectTangerine(int[] t){
        Map<Integer, Integer> result = new HashMap<Integer, Integer>();
        
        for(int i = 0; i < t.length; i++){
            if(result.containsKey(t[i])){
                result.put(t[i], result.get(t[i]) + 1);
            } else {
                result.put(t[i], 1);
            }
        }
        
        return result;
    }
}