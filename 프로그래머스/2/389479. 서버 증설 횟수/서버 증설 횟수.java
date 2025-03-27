import java.util.*;

class Solution {
    int m, k;
    int[] players;
    Map<Integer, Integer> server = new HashMap<>();
    
    public int solution(int[] players, int m, int k) {
        preSetting(players, m, k);
        
        return expand();
    }
    
    // osc: 현재 운영중인 서버 수, ec: 서버 증설 횟수, 
    // p: 게임이용자 수, asc: 추가 서버 수, dsc: 제거 대상 서버 수
    int expand(){
        int p, osc, ec, asc, dsc;
        
        osc = 0;
        ec = 0;
        for(int i = 0; i < 24; i++){
            dsc = server.getOrDefault(i - k, 0);
            osc -= dsc;
            p = players[i];
            
            if(m * (osc + 1) <= p){
                asc = p / m - osc;
                server.put(i, asc);
                ec += asc;
                osc += asc;
            }
        }
        return ec;
    }
    
    void preSetting(int[] players, int m, int k){
        this.players = players;
        this.m = m;
        this.k = k;
    }
}