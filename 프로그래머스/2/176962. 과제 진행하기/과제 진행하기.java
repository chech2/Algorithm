import java.util.*;

/*
    전략: 일단 현재 진행해야 하는 과제를 하나 꺼냄

    그리고 그 다음 과제의 시작 시간 vs 현 과제 시작시간 + 수행시간 
        시간이 넉넉하면
            1. 현 과제 처리해버리고 결과에 이름 담기
            2. 다 처리하지 못한 과제가 존재한다면, 그거 시간 처리
                -> 아직 가장 최근에 들어온 순서로 처리 못했는데 큐 대신 스택으로 처리 못한 과제 담기

        시간이 넉넉하지 못하다면 
            1. 현 과제의 남은 시간 줄이기
            2. 스택에 담기
            -> 다음 과제로 넘어가기 ㄱㄱ
*/

class Solution {
    sbject[] sbjects;
    int plan_cnt;
    
    public String[] solution(String[][] plans) {
        pre_setting(plans);
        return study();
    }
    
    String[] study() {
        String[] answer = new String[plan_cnt];;
        Stack<sbject> stack = new Stack<>();
        
        sbject now, next, remain;
        int time, idx;
        
        idx = 0; 
        for(int i = 0; i < plan_cnt - 1; i++){
            now = sbjects[i];
            next = sbjects[i + 1];
            
            time = now.start + now.play;
            if(time <= next.start) { // 과제를 다 끝낼 수 있는 경우
                answer[idx++] = now.name;
                
                while(!stack.isEmpty()){
                    remain = stack.pop();
                    
                    if(time + remain.remain <= next.start) { // 다 못끝낸 과제도 끝낼 수 있는 경우
                        answer[idx++] = remain.name;
                        time += remain.remain;
                    
                    }else {
                        remain.remain -= (next.start - time);
                        stack.add(remain);
                        break;
                    }
                }
                
            }else{
                now.remain -= (next.start - now.start);
                stack.add(now); 
            }
        }
        
        answer[idx++] = sbjects[plan_cnt - 1].name;
        System.out.println(Arrays.toString(answer));

        time = sbjects[plan_cnt - 1].start + sbjects[plan_cnt - 1].play;
        while(!stack.isEmpty()){
            remain = stack.pop();
            answer[idx++] = remain.name;
        }
        return answer;
    }
    
    void pre_setting(String[][] plans) {
        this.plan_cnt = plans.length;
        int info_cnt = 3;
        sbjects = new sbject[plan_cnt];
    
        String[] plan;
        for(int i = 0; i < plan_cnt; i++){
           plan = plans[i];
        
           sbjects[i] = new sbject(plan[0], plan[1], plan[2]);
        }
        
        Arrays.sort(sbjects, (sbject a, sbject b) -> a.start - b.start);
    }
}

class sbject {
    String name;
    int start, play, remain;
    
    sbject(String name, String start, String play){
        this.name = name;
        change_seconds(start, play);
    }
    
    private void change_seconds(String start, String play){
        this.play = Integer.parseInt(play) * 60;
        this.remain = this.play;
        
        String[] time = start.split(":");
        this.start = Integer.parseInt(time[0]) * 3600 + Integer.parseInt(time[1]) * 60;
    }
}