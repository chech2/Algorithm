import java.util.*;

class Solution {
    Map<String, List<Integer>> people;
    Map<String, Integer> language, job, career, food;
    public int[] solution(String[] info, String[] query) {
        int[] answer = new int[query.length];
        people = new HashMap<>();
        for(int i = 0; i < info.length; i++) formatting(info[i].split(" "));
        for(List<Integer> list : people.values()) Collections.sort(list);
        
        for(int i = 0; i < query.length; i++){
            String[] q = query[i].replaceAll(" and ", " ").split(" ");
            
            String key = String.join("", q[0], q[1], q[2], q[3]);
            int target = Integer.parseInt(q[4]);

            List<Integer> scores = people.get(key);

            if(scores == null) answer[i] = 0;
            else answer[i] = scores.size() - binarySearch(scores, target);
        }                                            
        return answer;
    }

    int binarySearch(List<Integer> list, int target){
        int s = 0, e = list.size();
        while(s < e){
            int m = (s + e) / 2;
            if(list.get(m) < target) s = m + 1;
            else e = m;
        }
        return s;
    }
    
    void formatting(String[] p){
        StringBuilder sb = new StringBuilder();
        
        String[] l = { p[0], "-" };
        String[] j = { p[1], "-" };
        String[] c = { p[2], "-" };
        String[] f = { p[3], "-" };

        String key;
        List<Integer> score;
        for(String w : l){
            for(String x : j){
                for(String y : c){
                    for(String z : f){
                        key = String.join("", w, x, y, z);
                        
                        if(people.containsKey(key)) {
                            score = people.get(key);
                            score.add(Integer.parseInt(p[4]));
                        } else {
                            score = new ArrayList<>();
                            score.add(Integer.parseInt(p[4]));
                        }
                        people.put(key, score);
                    }
                }
            }   
        }

    }
}