import java.util.*;

class Solution {

    public int solution(String[][] book_time) {
        int[] timeLine;
        int answer = 0;
        
        timeLine = new int[24 * 60 + 10];
        
        
        int start, end;        
        for(String[] now : book_time){
            start = transfer(now[0].split(":"));
            end = transfer(now[1].split(":")) + 10;
            
            // System.out.println(start + " " + end);
            timeLine[start]++;
            timeLine[end]--;
            // System.out.println(timeLine[start] + " " + timeLine[end]);
        }
        // System.out.println();
        
        for(int i = 1; i < 24 * 60 + 10; i++){
            timeLine[i] += timeLine[i - 1];
            answer = Math.max(answer, timeLine[i]);
        }
        
        // for(int i = 60; i < 250; i++) System.out.print(timeLine[i] + " ");
       
        return answer;
    }
    
    int transfer(String[] time){
        return Integer.parseInt(time[0]) * 60 + Integer.parseInt(time[1]);
    }
}