import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int n, maxValue, minValue;
    static int[][] map, minMemo, maxMemo;
    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception{
        input();
        for (int i = 0; i < 3; i++) {
            maxValue = Math.max(maxDP(0, i), maxValue);
        }

        for (int i = 0; i < 3; i++) {
            minValue = Math.min(minDP(0, i), minValue);
        }
        sb.append(maxValue).append(" ").append(minValue);
        System.out.println(sb);
    }

    //최대값 찾기
    public static int maxDP (int r, int c){
        if(n < r || c < 0 || 3 <= c) return -10000000; // 작은 값을 넣어서 손해로 만들기
        if(r == n) return 0;

        if(maxMemo[r][c] != -1) return maxMemo[r][c];
        return maxMemo[r][c] = Math.max(maxDP(r + 1, c), Math.max(maxDP(r + 1, c + 1), maxDP(r + 1, c - 1))) + map[r][c];
    }

    //최솟값 찾기
    public static int minDP (int r, int c){
        if(n < r || c < 0 || 3 <= c) return 10000000; // 큰 값을 넣어서 손해로 만들기
        if(r == n) return 0;

        if(minMemo[r][c] != -1) return minMemo[r][c];
        return minMemo[r][c] = Math.min(minDP(r + 1, c), Math.min(minDP(r + 1, c + 1), minDP(r + 1, c - 1))) + map[r][c];
    }

    public static void input() throws Exception{
        strToken();
        n = Integer.parseInt(st.nextToken());
        map = new int[n][3];
        maxMemo = new int[n][3];
        minMemo = new int[n][3];
        maxValue = Integer.MIN_VALUE;
        minValue = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            strToken();
            Arrays.fill(maxMemo[i], -1);
            Arrays.fill(minMemo[i], -1);
            for (int j = 0; j < 3; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }

    public static void strToken() throws Exception{
        st = new StringTokenizer(br.readLine());
    }

}