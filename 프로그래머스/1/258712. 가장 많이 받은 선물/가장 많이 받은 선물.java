import java.util.*;
import java.io.*;
class Solution {
    
    public int solution(String[] friends, String[] gifts) {
        int n = friends.length;
        int m = gifts.length;
        
        int[][] list = new int[n][n]; // 주고 받은 선물 리스트
        int[] nextlist = new int[n];  // 다음달에 받게 될 선물 개수
        int[][] info = new int[n][3]; // 각 사람별 받은 선물의 개수, 준 선물의 개수, 선물 지수
        HashMap <String, Integer> map = new HashMap();
        // 이름과 인덱스 매핑
        for(int i = 0; i < n; i++){
            map.put(friends[i], i);
        }
        
        for(int k = 0; k < m; k++){
            String[] names = gifts[k].split(" ");
            list[map.get(names[0])][map.get(names[1])]++;
            info[map.get(names[0])][0]++; // 준 기록
            info[map.get(names[1])][1]++; // 받은 기록
        }
        
        // 각 인원별 선물 지수 계산
        for(int i = 0; i < n; i++){
            info[i][2] = info[i][0] - info[i][1];
        }
        
        // for(int i = 0; i < n; i++){
        //     System.out.println(Arrays.toString(list[i]));
        // }
        // for(int i = 0; i < n; i++){
        //     System.out.print(info[i][2] + " ");
        // }
        // System.out.println();
        
        int sumi, sumj;    
        for(int i = 0; i < n; i++){
            for(int j = i + 1; j < n; j++){
                if((list[i][j] == list[j][i] && info[i][2] == info[j][2])) continue;
                if(list[i][j] == list[j][i]){
                    if(info[i][2] < info[j][2]) nextlist[j]++;
                    else nextlist[i]++;
                    
                }
                else if(list[i][j] < list[j][i]) nextlist[j]++;
                else nextlist[i]++;
            }
        }        
        Arrays.sort(nextlist);
     
        return nextlist[n - 1];
    }
}