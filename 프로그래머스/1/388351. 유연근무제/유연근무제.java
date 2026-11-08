import java.util.*;
class Solution {
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        int answer = 0;
        int n = schedules.length;     
        
        for(int i = 0; i < n; i++){
            if(!isLate(schedules[i], timelogs[i], startday)) answer++;
            // System.out.println();
        }

        return answer;
    }
    
    boolean isLate(int time, int[] timelogs, int startday){
        int end = 0;
        
        if(time % 100 < 50) {
            end = time + 10;
        } else {
            end = (time / 100 + 1) * 100 + (time % 100 - 60) + 10;
        }
        
        // System.out.println(time + " " + end + " " + Arrays.toString(timelogs) + " " + startday);
        for(int i = 0; i < timelogs.length; i++){
            if(startday == 1 && (i == 5 || i == 6)) continue;
            if(startday == 2 && (i == 4 || i == 5)) continue;
            if(startday == 3 && (i == 3 || i == 4)) continue;
            if(startday == 4 && (i == 2 || i == 3)) continue;
            if(startday == 5 && (i == 1 || i == 2)) continue;
            if(startday == 6 && (i == 0 || i == 1)) continue;
            if(startday == 7 && (i == 0 || i == 6)) continue;
            // System.out.println(end + " " + timelogs[i] + " " + startday);
  
            if(end < timelogs[i]) return true;
          }
        return false;
    }
}