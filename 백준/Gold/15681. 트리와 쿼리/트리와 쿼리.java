import java.io.*;
import java.util.*;

public class Main {
    static int n, r, q;
    static int[] sub, output_list;
    static ArrayList<Integer> graph[];
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws Exception{
        pre_setting();
        dfs(r, 0);
        for(int i = 0; i < q; i++) sb.append(sub[output_list[i]]).append("\n");
        bw.append(sb);
        bw.close();
    }

    static void dfs(int now, int pre){
        int next;

        for(int i = 0; i < graph[now].size(); i++){
            next = graph[now].get(i);

            if(next == pre) continue;
            dfs(next, now);
            sub[now] += sub[next];
        }
    }

    static void pre_setting() throws Exception{
        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        q = Integer.parseInt(st.nextToken());

        graph = new ArrayList[n + 1];
        sub = new int[n + 1];
        output_list = new int[q];
        Arrays.fill(sub, 1);
        for(int i = 0; i < n + 1; i++) graph[i] = new ArrayList<>();

        int a, b;
        for(int i = 0; i < n - 1; i++){
            st = new StringTokenizer(br.readLine());

            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
            graph[b].add(a);
        }

        for(int i = 0; i < q; i++) output_list[i] = Integer.parseInt(br.readLine());
    }
}