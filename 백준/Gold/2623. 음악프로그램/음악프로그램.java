import java.sql.Struct;
import java.util.*;
import java.io.*;
public class Main {
    static int n, m;
    static int[] d;
    static List<Integer>[] graph;
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws Exception{
        pre_setting();

        if(singer_sort()) bw.append(sb);
        else  bw.append('0');
        bw.close();
    }

    static boolean singer_sort(){
        int cnt = n;
        Queue<Integer> q = new ArrayDeque<>();
        for(int i = 1; i < n + 1; i++) if(d[i] == 0) q.add(i);


        int now, next;
        while(!q.isEmpty()){
            now = q.poll();

            if(d[now]-- == 0){
                sb.append(now + "\n");
                cnt--;
            }
            for(int i = 0; i < graph[now].size(); i++){
                next = graph[now].get(i);

                d[next]--;
                if(d[next] == 0) q.add(next);
            }
        }
        if(cnt == 0) return true;
        else return false;

    }
    static void pre_setting() throws Exception{
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        graph = new ArrayList[n + 1];
        d = new int[n + 1];

        for(int i = 0; i < n + 1; i++) graph[i] = new ArrayList<>();

        int SIZE, p, c;
        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            SIZE = Integer.parseInt(st.nextToken());
            p =  Integer.parseInt(st.nextToken());
            for(int j = 1; j < SIZE; j++) {
                c = Integer.parseInt(st.nextToken());

                graph[p].add(c);
                d[c]++;
                p = c;
            }
        }
    }
}