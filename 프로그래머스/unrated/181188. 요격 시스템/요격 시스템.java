import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
    public int solution(int[][] targets) {
        int ans = 1;
        int size = targets.length;
        int end = 0;
        
        Arrays.sort(targets, (o1, o2) -> { if(o1[1] == o2[1]) 
                                                return o1[0] - o2[0];
                                            return o1[1] - o2[1]; });
        end = targets[0][1];
        
        for(int i = 1; i < size; i++){
            if(targets[i][0] >= end){
                end = targets[i][1];
                ans++;
            }
        }
        System.out.println(ans);
        return ans;
    }
}