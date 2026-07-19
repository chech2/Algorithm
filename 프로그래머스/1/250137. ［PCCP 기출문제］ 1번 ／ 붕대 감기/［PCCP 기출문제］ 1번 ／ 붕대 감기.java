/*
t동안 1초에 x만큼 체력을 회복
t연속 붕대 감기 성공하면 y만큼 추가 회복

기술 사용 중 공격 -> 기술 취소 -> 다시 시작 (연속 성공 0초)

*/
import java.util.*;

class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int answer = -1;
        int start = 0;
        int max = health;
        
        int[] attack;
        int keep, add;
        for(int i = 0; i < attacks.length; i++){
            attack = attacks[i];
            keep = attack[0] - start - 1;
            add = keep * bandage[1] + keep / bandage[0] * bandage[2];
            
            // System.out.println(Arrays.toString(attack) + " " +  keep + " " + add);
            if(max <= add + health) health = max;
            else health += add;
            
            health -= attack[1];
            // System.out.println(health);

            if(health < 1) return -1;
            
            start = attack[0];
        }
        answer = health;
        return answer;
    }
}