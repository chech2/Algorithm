import java.io.*;
import java.util.*;

public class Main {
    static final int not_visited_school = -100000000;
    static int[] d = {1, -1};
    static int n;
    static int[] map;
    static int[][][] memo;
    
    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws Exception{
        pre_setting();
        int ans = recur(0, 0, 0);
        if(0 < ans) bw.append(String.valueOf(ans));
        else bw.append("-1"); 
        bw.close();
    }


    static int recur(int now, int idx, int change_d){
        if(now == n - 1) return 0;
        if(now < 0 || n <= now || map[now] == 0) return not_visited_school;
        if(memo[now][idx][change_d] != -1) return memo[now][idx][change_d];

        int next, rot;
        rot = not_visited_school;
        for(int i = 0; i < 2; i++){
            next = now + (map[now] * d[i]);

            if(i == idx) rot = Math.max(rot, recur(next, idx, change_d) + 1);
            else if(change_d < 2) rot = Math.max(rot, recur(next, i, change_d + 1) + 1);
        }
        return memo[now][idx][change_d] = rot;
    }

    static void pre_setting() throws Exception{
        n = Integer.parseInt(br.readLine());
        map = new int[n];
        memo = new int[n][2][3];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            map[i] = Integer.parseInt(st.nextToken());
            for(int j = 0; j < 2; j++) Arrays.fill(memo[i][j], -1);
        }
    }
}