import java.io.*;
import java.util.*;

public class Main {
    static final int MAX = 400000;
    static int n, ans;
    static int[] dance;
    static int[][][] dp;
    static Map<Integer, Integer> move;
    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    /*
        문제가 제시하는 위치로 발을 이동 시키는 게임
            -> 각각의 위치에 존재하는 왼발, 오른발을 움직여 가장 작게 움직이는 방법을 구하시오

        1. 2개의 옵션이 있음 (왼발, 오른발)

    */
    public static void main(String[] args) throws Exception{
        pre_setting();
        System.out.println(recur(0, 0, 0));
    }

    static void pre_setting() throws Exception{
        st = new StringTokenizer(br.readLine());
        n = st.countTokens() - 1;
        dance = new int[n];
        dp = new int[n][5][5];
        ans = MAX;
        move = new HashMap<>();

        for(int i = 0; i < 7; i++){
            if(i == 4 || i == 6) move.put(i, 4);
            else move.put(i, 3);
        }

        for(int i = 0; i < n; i++) dance[i] = Integer.parseInt(st.nextToken());
    }

    static int recur(int cnt, int r, int l){
        if(cnt == n) return 0;

        if(dp[cnt][r][l] != 0) return dp[cnt][r][l];
        int next, rot;
        next = dance[cnt];
        rot = MAX;

        // 오른발
        if(r == 0) rot = Math.min(recur(cnt + 1, next, l) + 2, rot);
        else if(r == next) rot = Math.min(recur(cnt + 1, next, l) + 1, rot);
        else if(l != next) rot = Math.min(recur(cnt + 1, next, l) + move.get((r + next) % 7), rot);

        // 왼발
        if(l == 0) rot = Math.min(recur(cnt + 1, r, next) + 2, rot);
        else if(l == next) rot = Math.min(recur(cnt + 1, r, next) + 1, rot);
        else if(r != next) rot = Math.min(recur(cnt + 1, r, next) + move.get((l + next) % 7), rot);

        return dp[cnt][r][l] = rot;
    }
}