import java.io.*;
import java.util.*;
public class Main {
    static int n, h;
    static ArrayList<point>[] points;
    static boolean[] visited;
    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


    static class point{
        int x, y, cnt, num;

        point(int x, int num){
            this.x = x;
            this.num = num;
        }

        point(int x, int y, int cnt){
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
    }

    public static void main(String[] args) throws Exception{
        input();
        System.out.println(bfs());
    }

    public static int bfs() {
        PriorityQueue<point> q = new PriorityQueue<>((o1, o2) -> o1.cnt - o2.cnt);
        q.add(new point(0, 0, 0));

        point now, next;
        int x, nX;
        while(!q.isEmpty()){
            now = q.poll();

            x = now.x;
            if(now.y == h) return now.cnt;

            // 이동할 수 있는 y좌표의 범위
            for (int nY = now.y - 2; nY < now.y + 3; nY++) {

                if(h < nY || nY < 0) continue;

                // 이동할 수 있는 x좌표의 범위
                for (int j = 0; j < points[nY].size(); j++) {

                    next = points[nY].get(j);
                    nX = next.x;

                    // 이미 이동한 좌표
                    if(visited[next.num]) continue;

                    // 범위를 벗어난 경우
                    if(2 < Math.abs(nX - x)) continue;

                    visited[next.num] = true;

                    q.add(new point(nX, nY, now.cnt + 1));
                }
            }
        }

        return -1;
    }

    public static void input() throws Exception{
        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());

        points = new ArrayList[h + 1];
        visited = new boolean[n];

        for (int i = 0; i < h + 1; i++) points[i] = new ArrayList<>();

        int x, y;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());
            points[y].add(new point(x, i));
        }

        for (int i = 0; i < h + 1; i++) {
            Collections.sort(points[i], new Comparator<>() {
                @Override
                public int compare(point o1, point o2) {
                    return o1.x - o2.x;
                }
            });
        }
    }
}