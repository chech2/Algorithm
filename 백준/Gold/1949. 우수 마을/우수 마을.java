import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int[] people;
    static int[][] dp; // dp[i][0]: 선택했을 때 최대 값, dp[i][1]: 선택하지 않았을 때의 최대 값
    static ArrayList<Integer>[] graph;
    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws Exception{
        input();
        dfs(1, 0);

        System.out.println(Math.max(dp[1][0], dp[1][1]));

    }


    public static void dfs(int now, int pre){

        int next;
        for (int i = 0; i < graph[now].size(); i++) {
            next = graph[now].get(i);
            if(next == pre) continue;


            dfs(next, now);

            //현재 마을이 우수 마을인 경우, dp[now][0]
            dp[now][0] += dp[next][1];                          //뒷 동네는 우수 마을 불가능

            //현재 마을이 우수 마을이 아닌 경우
            dp[now][1] += Math.max(dp[next][0], dp[next][1]);   //뒷 동네 우수 마을 가능
        }
        dp[now][0] += people[now];
    }

    public static void strToken() throws Exception{
        st = new StringTokenizer(br.readLine());
    }
    public static void input() throws Exception{
        strToken();
        n = Integer.parseInt(st.nextToken());

        people = new int[n + 1];
        dp = new int[n + 1][2];
        graph = new ArrayList[n + 1];
        strToken();
        for (int i = 1; i < n + 1; i++) {
            graph[i] = new ArrayList<>();
            people[i] = Integer.parseInt(st.nextToken());
        }

        int n1, n2;
        for (int i = 0; i < n - 1; i++) {
            strToken();
            n1 = Integer.parseInt(st.nextToken());
            n2 = Integer.parseInt(st.nextToken());
            graph[n1].add(n2);
            graph[n2].add(n1);
        }
    }

}