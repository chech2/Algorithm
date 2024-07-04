import java.io.*;
import java.util.*;
public class Main {

    static int n, k;
    static boolean[] visited;
    static boolean flag;
    static int[] d = {-1, 1, 2};
    static node result;
    static StringTokenizer st;
    static BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static class node{
        int x, t;
        String str = "";
        node(int x, int t, String str){
            this.x = x;
            this.t = t;
            this.str += str + x + " ";
        }
    }
    public static void main(String[] args) throws Exception{
        input();
        if(k < n) {
            sb.append((n - k)).append("\n");
            for (int i = n; k <= i; i--) {
                sb.append(i).append(" ");
            }
        }
        else{
            if(n != k) bfs();
            else result = new node(n, 0, "");

            sb.append(result.t).append("\n");
            sb.append(result.str);
        }

        System.out.println(sb);
    }

    public static void bfs(){
        PriorityQueue<node> q = new PriorityQueue<>((o1, o2) -> o1.t - o2.t);
        q.add(new node(n, 0, ""));

        node now, next;
        int nX;
        while(!q.isEmpty()){
            now = q.poll();

            for (int i = 0; i < 3; i++) {
                if(i != 2) nX = now.x + d[i];
                else nX  = now.x * d[i];

                if(nX < 0 || 100001 < nX || visited[nX]) continue;

                visited[nX] = true;
                next = new node(nX, now.t + 1, now.str);
                if(nX == k) {
                    result = next;
                    return;
                }
                else q.add(next);
            }
        }
    }

    public static void input() throws Exception{
        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        visited = new boolean[100002];
        visited[n] = true;
    }

}