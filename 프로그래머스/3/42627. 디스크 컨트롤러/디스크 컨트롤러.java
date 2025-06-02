import java.util.*;

class Solution {
    PriorityQueue<job> q;
    int t;
    int[][] jobs;
    
    public int solution(int[][] jobs) {
        setting(jobs);
        int answer = working();
        return answer;
    }
    
    int working(){
        int answer;
        int[] now;
        job pre;
        
        answer = 0;
        for(int i = 0; i < jobs.length; i++){
            now = jobs[i];
            if(t < now[0]){
                
                if(q.isEmpty()) t = now[0];
                else i--;
            }
            
            if(now[0] <= t) i = putQOvertime(i, t);
            if(!q.isEmpty()){
                pre = q.poll();
                answer += calculation(pre);     

            }
        }
        
        while(!q.isEmpty()){
            pre = q.poll();
            
            answer += calculation(pre);     
        }
        
        return answer / jobs.length;
    }
    
    int calculation(job pre){
        int answer;
        
        if(t < pre.s){ // 시작시간을 지나지 않은 경우
                answer = pre.t;
                t = pre.t + pre.s;

        }else{ // 시작시간을 지난 경우
                answer = (t - pre.s) + pre.t;
                t += pre.t;
        }
        System.out.println(pre.n + " " + t);
        
        return answer;
    }
    
    int putQOvertime(int j, int t){
        while(j < jobs.length && jobs[j][0] <= t){
            q.add(new job(j, jobs[j][0], jobs[j][1]));             
            j++;
        }
        return --j;
    }
    
    void setting(int[][] jobs) {
        Arrays.sort(jobs, (o1, o2) -> {
            return o1[0] - o2[0];
        });
        
        this.jobs = jobs;
        q = new PriorityQueue<>((o1, o2) -> {
            if(o1.t == o2.t){
                if(o1.s == o2.s) return o1.n - o2.n;
                return o1.s - o2.s;
            }
            return o1.t - o2.t;
        });
    }
    
    class job{
        int s, t, n;
        job(int n, int s, int t){
            this.n = n;
            this.s = s;
            this.t = t;
        }
    }
}