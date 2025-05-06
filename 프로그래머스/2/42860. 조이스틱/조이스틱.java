import java.util.*;

class Solution {
    public int solution(String name) {        
        char[] names = name.toCharArray();
        
        return  changeA(names) + moveRL(names);
    }
    
    int changeA(char[] name){
        int answer = 0;

        for(char now : name){
            if(13 < now - 'A') answer += ('Z' - now + 1);
            else answer += (now - 'A');
        }
        System.out.println(answer);
        return answer;
    }
    
    int moveRL(char[] name){
        int acnt, n, answer;
        n = name.length;
        answer = n - 1;
        
        for(int i = 0; i < n; i++){
            
            for(acnt = i + 1; acnt < n; acnt++){
                if(name[acnt] != 'A') break;
            }
            
            // 마지막 문자 ~ i까지 왼쪽으로 이동한뒤, 오른쪽으로 방향 전환해서 움직인 횟수
            answer = Math.min((n - acnt) * 2 + i, answer);
            // 첫 문자 ~ i까지 오른쪽으로 이동한 뒤,왼쪽을 방향 전환해서 움진인 횟수
            answer = Math.min(i * 2 + n - acnt, answer);
            
            System.out.println(i + " " + name[i] + "   " + (i * 2 + n - acnt) + " vs " + ((n - acnt) * 2 + i));
        }
        System.out.println(answer);
        return answer;
    }
}