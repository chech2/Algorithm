import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static int N;
    static int[] numbers, result;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();

        numbers = new int[N];
        result = new int[N];
        visited = new boolean[N];
        for (int i = 0; i < N; i++) numbers[i] = i + 1;
        perm(0);
        System.out.println(sb);
    }

    static void perm(int cnt){
        if(cnt == N){
            for (int i = 0; i < N; i++) {
                sb.append(result[i]).append(" ");
            }
            sb.append("\n");
            return;
        }
        for (int i = 0; i < N; i++) {
            if(visited[i]) continue;
            result[cnt] = numbers[i];
            visited[i] = true;
            perm(cnt + 1);
            visited[i] = false;

        }
    }
}