import java.util.*;
import java.io.*;

public class Main {

    static int w, h;
    static long ans;
    static long[][][][] memo;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws Exception {
        input();
        ans += dp(0, 2, 1, 1); // 아래로 내려감
        ans += dp(1, 1, 2, 1); // 옆으로 이동

        System.out.println(ans % 100000);
    }

    public static long dp(int dir, int r, int c, int flag) {
        if (w < r || h < c) return 0;
        if (r == w && c == h) {
            return 1;
        }
        if (memo[dir][r][c][flag] != 0) return memo[dir][r][c][flag];

        long ret = 0;
        // 방향 전환 가능
        if(flag == 1) {
            if (dir == 0) { // 아래
                ret += dp(2, r, c + 1, 0) % 100000; // 방향 전환 O, 아래 -> 오른쪽
                ret += dp(0, r + 1, c, 1) % 100000; // 방향 전환 X, 아래
            }
            if (dir == 1) { // 오른쪽
                ret += dp(3, r + 1, c, 0) % 100000; // 방향 전환 O, 오른쪽 -> 아래
                ret += dp(1, r, c + 1, 1) % 100000; // 방향 전환 X, 오른쪽
            }
        }
        else {
            // 방향 전환 불가능
            if (dir == 2) ret += dp(1, r, c + 1, 1) % 100000; // 오른쪽
            if (dir == 3) ret += dp(0, r + 1, c, 1) % 100000; // 아래
        }
        return memo[dir][r][c][flag] = ret;
    }

    public static void input() throws Exception{
        st = new StringTokenizer(br.readLine());
        w = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());

        memo = new long[4][w + 2][h + 2][2];
    }
}