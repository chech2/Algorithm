import java.io.*;
import java.util.*;

public class Main {
    static int t;
    static int[] num;
    static int[][] fibonArr;
    static StringBuilder sb = new StringBuilder();
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws Exception{
        inputSetting();

        for(int i = 0; i < 41; i++) {
            fibonArr[0][i] = fibonacciZero(i);
            fibonArr[1][i] = fibonacciOne(i);
        }

        for(int i = 0; i < t; i++) sb.append(fibonArr[0][num[i]]).append(" ").append(fibonArr[1][num[i]]).append("\n");
        bw.append(sb);
        bw.close();
    }

    static int fibonacciZero(int now){
        if(now < 0) return 0;
        if(fibonArr[0][now] != -1) return fibonArr[0][now];

        if(now == 0) return 1;

        return fibonArr[0][now] = fibonacciZero(now - 1) + fibonacciZero(now - 2);
    }

    static int fibonacciOne(int now){
        if(now <= 0) return 0;
        if(fibonArr[1][now] != -1) return fibonArr[1][now];

        if(now == 1) return 1;

        return fibonArr[1][now] = fibonacciOne(now - 1) + fibonacciOne(now - 2);
    }


    static void inputSetting() throws Exception{
        t = Integer.parseInt(br.readLine());
        num = new int[t];
        fibonArr = new int[2][41];

        for(int i = 0; i < 2; i++) Arrays.fill(fibonArr[i], -1);
        for(int i = 0; i < t; i++) num[i] = Integer.parseInt(br.readLine());

        fibonArr[0][0] = 1;
        fibonArr[0][1] = 0;
        fibonArr[1][0] = 0;
        fibonArr[1][1] = 1;
    }
}