class Solution {
    public int solution(int h1, int m1, int s1, int h2, int m2, int s2) {
        int answer, noon, afternoon, start, end;
        
        answer = 0;
        noon = 0;
        afternoon = 3600 * 12;
        start = change_time_to_second(h1, m1, s1);
        end = change_time_to_second(h2, m2, s2);
        
        System.out.println(noon + " " + afternoon + " " + start + " " + end);
        
        if(start == noon || start == afternoon) answer = 1;
        if(end == afternoon) answer =- 1;
        if(start < afternoon && afternoon < end) answer -= 1;
        
            
        return cal_rot_cnt(end) - cal_rot_cnt(start) + answer;
    }
    
    int cal_rot_cnt(int time){
        return (int)rot_minute_hand(time) + (int)rot_hour_hand(time);  
    }
    
    double rot_minute_hand(int time){
        return time * (59.0 / 3600);
    }
    
    double rot_hour_hand(int time){
        return time * (719.0 / 43200);
    }
    
    int change_time_to_second(int h, int m, int s){
        return h * 3600 + m * 60 + s;
    }
}