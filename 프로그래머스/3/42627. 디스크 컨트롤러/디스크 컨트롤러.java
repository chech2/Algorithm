import java.util.*;

class Solution {
    PriorityQueue<job> q;
    int t, idx, finished_jobs, workingTime;
    int[][] jobs;
    
    public int solution(int[][] jobs) {
        setting(jobs);
        int answer = working();
        return answer;
    }
    
    int working(){
        int[] now;
        job pre;
        
        while(finished_jobs != jobs.length){
            idx = putQOvertime(idx, t);
            
            if(!q.isEmpty()){
                pre = q.poll();
                
                workingTime += (t - pre.s) + pre.t;
                t += pre.t;
                finished_jobs++;
            } else t = jobs[idx][0];
        }
        
        return workingTime / jobs.length;
    }
    
    int putQOvertime(int j, int t){
        while(j < jobs.length && jobs[j][0] <= t){
            q.add(new job(j, jobs[j][0], jobs[j][1]));             
            j++;
        }
        return j;
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