import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int N, M, ans;
    static ArrayList<Integer>[] list;
    static boolean visited[];
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        list = new ArrayList[N + 1];
        visited = new boolean[N + 1];

        for (int i = 0; i < N + 1; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            list[n].add(m);
            list[m].add(n);
        }

        for (int i = 1; i < N + 1; i++) {
            if(!visited[i]) {
                dfs(i);
                ans++;
            }
        }
        System.out.println(ans);
    }
    static void dfs(int node){
        int size = list[node].size();
        for (int i = 0; i < size; i++) {
            int next = list[node].get(i);
            if(visited[next]) continue;
            visited[next] = true;
            dfs(next);
        }

    }
}