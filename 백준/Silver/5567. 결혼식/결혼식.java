import java.io.*;
import java.util.*;
import java.util.concurrent.atomic.AtomicBoolean;

public class Main {
    static int n, m, ans;
    static boolean[] visited;
    static List<Integer>[] friends;
    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception{
        inputSetting();
        dijka();
        System.out.println(ans);
    }

    private static void dijka(){
        Deque<relationship> q = new ArrayDeque<>();
        q.add(new relationship(1, 0));
        visited[1] = true;

        int next, now;
        relationship cur;
        while(!q.isEmpty()){
            cur = q.pop();
            now = cur.v;

            for(int i = 0; i < friends[now].size(); i++){
                next = friends[now].get(i);

                if(visited[next]) continue;
                if(cur.d + 1 <= 2){
                    visited[next] = true;
                    q.add(new relationship(next, cur.d + 1));
                    ans++;
                }
            }
        }
    }
    private static void inputSetting() throws Exception{
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        friends = new List[n + 1];
        visited = new boolean[n + 1];
        for(int i = 0; i < n + 1; i++){
            friends[i] = new ArrayList<>();
        }

        int e, v;
        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            e = Integer.parseInt(st.nextToken());
            v = Integer.parseInt(st.nextToken());

            friends[e].add(v);
            friends[v].add(e);
        }
    }

    static private class relationship{
        int e, v, d;

        relationship(int v, int d){
            this.v = v;
            this.d = d;
        }
    }
}