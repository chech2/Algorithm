import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int n, x, m, ans;
    static int[][] d;
    static ArrayList<node>[] map ;

    public static class node{
        int num, len;
        node(int num, int len){
            this.num = num;
            this.len = len;
        }
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        ans = Integer.MIN_VALUE;

        d = new int[n + 1][n + 1];
        map = new ArrayList[n + 1];
        for (int i = 1; i < n + 1; i++) {
            Arrays.fill(d[i], 2000000);
            map[i] = new ArrayList<>();
            d[i][i] = 0;
        }

        int start, end, len;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            start = Integer.parseInt(st.nextToken());
            end = Integer.parseInt(st.nextToken());
            len = Integer.parseInt(st.nextToken());

            map[start].add(new node(end, len));
        }

        for (int i = 1; i < n + 1; i++) {
            dijk(i);
        }

        for (int i = 1; i < n + 1; i++) {
            ans = Math.max(d[i][x] + d[x][i], ans);
        }
        System.out.println(ans);

    }

    public static void dijk(int start){
        ArrayDeque<Integer> q = new ArrayDeque<>();

        q.add(start);
        int now;
        node next;
        while(!q.isEmpty()){
            now = q.poll();

            for (int i = 0; i < map[now].size(); i++) {
                next = map[now].get(i);

                if(d[start][now] + next.len < d[start][next.num]){
                    d[start][next.num] = d[start][now] + next.len;
                    q.add(next.num);
                }
            }
        }
    }
}