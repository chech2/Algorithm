import java.io.*;
import java.util.*;

public class Main {

    static int n, TREE_LEN, lastNode;
    static int[] d;
    static List<node>[] graph;
    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception {
        inputSetting();
        dfs(1, 0);
        Arrays.fill(d, 0);
        dfs(lastNode, 0);
        System.out.println(TREE_LEN);
    }

    static void dfs(int now, int pre){
        node next;
        for(int i = 0; i < graph[now].size(); i++){
            next = graph[now].get(i);

            if(next.e == pre) continue;
            d[next.e] = d[now] + next.l;

            if(TREE_LEN < d[next.e]){
                TREE_LEN = d[next.e];
                lastNode = next.e;
            }

            dfs(next.e, now);
        }
    }

    static void inputSetting() throws Exception {
        n = Integer.parseInt(br.readLine());

        d = new int[n + 1];
        graph = new List[n + 1];
        for (int i = 0; i < n + 1; i++) {
            graph[i] = new ArrayList<node>();
        }

        int v, e, l;
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());

            v = Integer.parseInt(st.nextToken());
            while(st.hasMoreTokens()){

                e = Integer.parseInt(st.nextToken());

                if(e == -1) break;
                l = Integer.parseInt(st.nextToken());

                graph[v].add(new node(e, l));
            }
        }
    }

    static class node {
        int e, l;

        node(int e, int l) {
            this.e = e;
            this.l = l;
        }
    }
}