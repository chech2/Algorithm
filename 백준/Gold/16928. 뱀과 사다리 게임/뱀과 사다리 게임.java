import java.io.*;
import java.util.*;

public class Main {
    static boolean[] visited;
    static Map<Integer, Integer> snake, ladder;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws Exception{
        input();
        System.out.println(bfs());
    }

    static int bfs(){
        PriorityQueue<node> q = new PriorityQueue<>((o1, o2) -> o1.cnt - o2.cnt);
        q.add(new node(1, 0));
        visited[1] = true;

        node now;
        while (!q.isEmpty()) {
            now = q.poll();

            if(now.n == 100) return now.cnt;

            if (snake.containsKey(now.n)) {
                q.add(new node(snake.get(now.n), now.cnt));
            } else if (ladder.containsKey(now.n)) {
                q.add(new node(ladder.get(now.n), now.cnt));
            } else {
                for (int i = 1; i < 7; i++) {
                    if(100 < now.n + i) break;
                    if(visited[now.n + i]) continue;

                    visited[now.n + i] = true;
                    q.add(new node(now.n + i, now.cnt + 1));
                }
            }
        }
        return 0;
    }

    static void input() throws Exception{
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        visited = new boolean[101];
        snake = createMap(new HashMap<>(), n);
        ladder = createMap(new HashMap<>(), m);
    }

    static Map<Integer, Integer> createMap(Map<Integer, Integer> returnMap, int size) throws Exception{
        StringTokenizer st;

        for(int i = 0; i < size; i++){
            st = new StringTokenizer(br.readLine());

            returnMap.put(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        return returnMap;
    }

    static class node{
        int n, cnt;
        node(int n, int cnt){
            this.n = n;
            this.cnt = cnt;
        }
    }
}