import java.util.*;
import java.io.*;
import java.lang.*;

class Solution {
    public long solution(int r1, int r2) {
        double inner = Math.pow(r1, 2);
        double outter = Math.pow(r2, 2);
        long answer = 0;
            
        for(int i = 1; i <= r2; i++){
            double num = Math.pow(i, 2); //inner에 의한 y좌표의 값, 정수 => 정수쌍 완성
            
            int start = (int)Math.ceil(Math.sqrt(inner - num));
            int end = (int)Math.floor(Math.sqrt(outter - num));
            
            // System.out.println(start + " " + end + " 다른 결과값을 확인: " + start + " " + end);

            answer += (end - start + 1);
        }
        answer *= 4;
    
        
        return answer;
    }
}