import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int[] p;
    static List<Integer>[] tree;
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws Exception{
        preSetting();
        dfs(0, 1);
        print();
        
    }
    
    static void print() throws Exception{
        for(int i = 2; i < n + 1; i++) sb.append(p[i]).append("\n");
        bw.append(sb);
        bw.close();
    }

    static void dfs(int pre, int now){

        int next;
        for(int i = 0; i < tree[now].size(); i++){
            next = tree[now].get(i);

            if(next == pre) continue;
            p[next] = now;
            dfs(now, next);
        }
    }

    static void preSetting() throws Exception{
        n = Integer.parseInt(br.readLine());

        p = new int[n + 1];
        tree = new ArrayList[n + 1];

        p[1] = 1;
        for(int i = 0; i < n + 1; i++) tree[i] = new ArrayList<>();

        int a, b;
        for(int i = 0 ; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());

            tree[a].add(b);
            tree[b].add(a);
        }
    }
}