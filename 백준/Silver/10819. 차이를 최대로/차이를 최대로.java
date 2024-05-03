import java.util.*;
import java.io.*;
public class Main {

    static int n, maxVal;
    static boolean[] visited;
    static int[] numbers;
    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws Exception{
        input();
        perm(0, 0, 0);
        System.out.println(maxVal);
    }

    public static void perm(int cnt, int pre, int sum){
        if(cnt == n){
            maxVal = Math.max(maxVal, sum);
            return;
        }

        for (int i = 0; i < n; i++) {
            if(visited[i]) continue;

            visited[i] = true;
            if(cnt != 0) perm(cnt + 1, numbers[i],sum + Math.abs(pre - numbers[i]));
            else perm(cnt + 1, numbers[i], sum);
            visited[i] = false;
        }
    }

    public static void input() throws Exception{
        n = Integer.parseInt(br.readLine());
        visited = new boolean[n];
        numbers = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }
    }
}