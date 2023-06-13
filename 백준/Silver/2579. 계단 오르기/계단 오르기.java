import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static int[][] memo;
    static int [] origin;
    static int N;
    static boolean[] visited;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        memo = new int[2][N + 1];
        origin = new int[N + 1];
        visited = new boolean[N + 1];
        Arrays.fill(memo[0], -1);
        memo[0][0] = 0;
        memo[0][1] = 0;

        for (int t = 1; t < N + 1; t++) {
            int num = sc.nextInt();
            origin[t] = num;
            if(t < 3) {
                memo[0][t] = memo[0][t - 1] + num;
                memo[1][t] += memo[1][t - 1]+ 1;
            }
            else memo[0][t] = dp(t, num);

        }
        System.out.println(memo[0][N]);
    }
    static int dp(int idx, int num){
        int n1 = memo[0][idx - 1]; // 1번 앞 계단까지의 최고값(연속 상관없이)
        int n2 = memo[0][idx - 2] + num; //2번 앞 계단까지의 최고값 + 현재 계단
        int n3 = memo[0][idx - 3] + origin[idx - 1] + num; //4번 앞 계단까지의 최고값 + 1번 앞 계단 + 현재 계단
        if(memo[1][idx - 1] == 2) {
            if(n3 < n2){
                memo[1][idx] = 1;
                return n2;
            }else{
                memo[1][idx] = 2;
                return n3;
            }
        }
        int maxNum = Math.max(Math.max(n1, n2), n3);
        if(maxNum == n2) {
            memo[1][idx] = memo[1][idx - 1] + 1;
        }else if(maxNum == n3){
            memo[1][idx] = 2;
        }
        else memo[1][idx] = 1;
        return maxNum;
    }
}