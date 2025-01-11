import java.util.*;

class Solution {
    int type, n;
    int[][] watting_timetable;
    List<mentee>[] mentees;
    
    public int solution(int k, int n, int[][] reqs) {
        int answer = 0;
        pre_setting(k, n, reqs);
        
        for(int i = 1; i < type + 1; i++){
            for(int j = 1; j < n - type + 2; j++){
                watting_timetable[i][j] = watting_time(i, j);
            }
            answer += watting_timetable[i][1];
        }
        answer = calcuration_mentor_cnt(answer);
        
        return answer;
    }
    
    int calcuration_mentor_cnt(int total_time){
        int remain_mentor, decrease_time, decrease_type, cur_time, next_time;

        int[] cur_mentor_cnt = new int[type + 1];
        Arrays.fill(cur_mentor_cnt, 1);

        remain_mentor = n - type;
        while(0 < remain_mentor--){
            decrease_time = 0;
            decrease_type = 0;

            for(int i = 1; i < type + 1; i++){
                if(n - type + 1 < cur_mentor_cnt[i] + 1) continue;

                cur_time = watting_timetable[i][cur_mentor_cnt[i]];
                next_time = watting_timetable[i][cur_mentor_cnt[i] + 1];

                if(cur_time - next_time <= decrease_time) continue;
                else{
                    decrease_time = cur_time - next_time;
                    decrease_type = i;
                }
            }
            total_time -= decrease_time;
            cur_mentor_cnt[decrease_type]++;
        }

        return total_time;
    }
    
    int watting_time(int type, int mentor){
        PriorityQueue<Integer> q = new PriorityQueue<>();
        int mentee_cnt = mentees[type].size();
        int watting_time = 0;
            
        mentee p;
        int time;
        for(int i = 0; i < mentee_cnt; i++){
            p = mentees[type].get(i);
            
            if(q.isEmpty() || q.size() < mentor) q.add(p.start + p.talk);
            else{
                time = q.poll();
                
                if(time <= p.start) q.add(p.start + p.talk);
                else{
                    watting_time += Math.abs(p.start - time);
                    time += p.talk;
                    q.add(time);
                }
            }
        }
        
        return watting_time;
    }
    
    void pre_setting(int k, int n, int[][] reqs){
        this.type = k;
        this.n = n;
        watting_timetable = new int[type + 1][n - type + 2];
        mentees = new ArrayList[type + 1];
        
        for(int i = 0; i < type + 1; i++) mentees[i] = new ArrayList<>();
    
        int[] now;
        for(int i = 0; i < reqs.length; i++){
            now = reqs[i];
            mentees[now[2]].add(new mentee(now[0], now[1]));
        }
    }
}

class mentee{
    int start, talk;
    
    mentee(int start, int talk){
        this.start = start;
        this.talk = talk;
    }
}