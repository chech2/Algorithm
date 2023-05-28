import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static int N, M, end;
    static int result[];
    static int memo[] = new int[708];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        int now;

        memo[0] = 0;
        for (int i = 1; i < 709; i++) {
            now = i * i;
            if (N < now) break;
            memo[i] = now;
            end = i;
        }
        for (int i = 1; i < 5; i++) {
            M = i;
            result = new int[M];
            cmbi( 0, 0);
        }

    }

    static void cmbi(int cnt, int ans) {
        if (cnt == M) {
            if (ans == N) {
                System.out.println(M);
                System.exit(0);
            }
            return;
        }
        for (int i = 1; i <= end; i++) {
            cmbi( cnt + 1, ans + memo[i]);
        }
    }
}