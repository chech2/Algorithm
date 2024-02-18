import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int n, ans;
    static int[] t;
    static int[][][][] memo;
    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws Exception{
        input();
        System.out.println(recur(0, 0, 0, 0));
    }

    public static int recur(int food, int t1, int t2, int t3){
        if(food == n) return 0;

        if(memo[food][t1][t2][t3] != -1) return memo[food][t1][t2][t3];

        // 각 인덕션 별로 +, - 누르는 경우
        // 0번 누르는 경우
        int p, m, ans;

        p = plus(t1, t[food]);
        m = minus(t1, t[food]);
        ans = recur(food + 1, t[food], t2, t3) + p; // + 누를 경우
        ans = Math.min(recur(food + 1, t[food], t2, t3) + m, ans);

        // 1번 누르는 경우
        p = plus(t2, t[food]);
        m = minus(t2, t[food]);
        ans = Math.min(recur(food + 1, t1, t[food], t3) + p, ans); // + 누를 경우
        ans = Math.min(recur(food + 1, t1, t[food], t3) + m, ans);

        // 2번 누르는 경우
        p = plus(t3, t[food]);
        m = minus(t3, t[food]);
        ans = Math.min(recur(food + 1, t1, t2, t[food]) + p, ans); // + 누를 경우
        ans = Math.min(recur(food + 1, t1, t2, t[food]) + m, ans);

        return memo[food][t1][t2][t3] = ans;
    }

    public static int plus(int me, int target){
        if(me < target){
            return Math.abs(target - me);
        }else{
            return Math.abs(9 - me) + 1 + target;
        }
    }

    public static int minus(int me, int target){
        if(me < target){
            return me + 1 + Math.abs(9 - target);
        }else{
            return Math.abs(target - me);
        }
    }

    public static void input() throws Exception{
        strToken();
        n = Integer.parseInt(st.nextToken());
        t = new int[n];
        ans = Integer.MAX_VALUE;
        memo = new int[n][10][10][10];
        strToken();
        for (int i = 0; i < n; i++) {
            t[i] = Integer.parseInt(st.nextToken());
            for (int j = 0; j < 10; j++) {
                for (int k = 0; k < 10; k++) {
                    Arrays.fill(memo[i][j][k], -1);
                }
            }
        }
    }

    public static void strToken() throws Exception{
        st = new StringTokenizer(br.readLine());
    }
}