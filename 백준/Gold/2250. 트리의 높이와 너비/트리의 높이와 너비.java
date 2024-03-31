import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {

    static int n, r, maxDepth, maxLevel, maxWidth, idx;
    static int[] d, s, p;
    static int[][] graph;
    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception{
        input();
        inorder(r, 1);
        findWidth();
        System.out.println(maxLevel + " " + maxWidth);
    }

    public static void inorder(int now, int cnt){
        if(graph[now][0] != -1) inorder(graph[now][0], cnt + 1);
        s[now] = ++idx;
        d[now] = cnt;
        maxDepth = Math.max(maxDepth, cnt);
        if(graph[now][1] != -1)inorder(graph[now][1], cnt + 1);
    }

    public static void findWidth(){
        ArrayList<node>[] width = new ArrayList[maxDepth + 1];

        for (int i = 0; i < maxDepth + 1; i++) width[i] = new ArrayList<>();
        for (int i = 1; i < n + 1; i++) {
            width[d[i]].add(new node(i, s[i]));
        }

        int tmpW;
        for (int i = 1; i < maxDepth + 1; i++) {
            Collections.sort(width[i], new Comparator<node>() {
                @Override
                public int compare(node o1, node o2) {
                    return o1.s - o2.s;
                }
            });

            tmpW = width[i].get(width[i].size() - 1).s - width[i].get(0).s + 1;
            if(maxWidth < tmpW || (maxWidth == tmpW && i < maxLevel)){
                maxWidth = tmpW;
                maxLevel = i;
            }
        }
    }

    public static void strToken() throws Exception{
        st = new StringTokenizer(br.readLine());
    }

    public static class node{
        int num, s;
        node (int num, int s) {
            this.num = num;
            this.s = s;
        }
    }

    public static void input() throws Exception{
        n = Integer.parseInt(br.readLine());

        graph = new int[n + 1][2];
        p = new int[n + 1];
        s = new int[n + 1];
        d = new int[n + 1];

        maxLevel = 10000;

        int n1, c1, c2;
        for (int i = 0; i < n; i++) {
            strToken();
            n1 = Integer.parseInt(st.nextToken());
            c1 = Integer.parseInt(st.nextToken());
            c2 = Integer.parseInt(st.nextToken());

            graph[n1][0] = c1;
            graph[n1][1] = c2;
            if(c1 != -1) p[c1] = n1;
            if(c2 != -1) p[c2] = n1;
        }

        for (int i = 1; i < n + 1; i++) {
            if(p[i] == 0) {
                r = i;
                break;
            }
        }
    }
}