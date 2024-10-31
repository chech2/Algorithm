import java.io.*;
import java.util.*;

public class Main {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static int n, m, time, ans, total;
    static int[][] map;
    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws Exception{
        pre_setting();
        int tmp;
        while(true){
            tmp = air();
            if(tmp == 0) break;
            total -= ans;

            ans = tmp;
            time++;
        }
        System.out.println(time + "\n" + total);
    }

    static int air(){
        ArrayDeque<node> q = new ArrayDeque<>();
        boolean[][] visited = new boolean[n][m];
        ArrayList<node> melt = new ArrayList();
        q.add(new node(0, 0));

        int nx, ny;
        node now;
        while(!q.isEmpty()){

            now = q.poll();
            for(int i = 0; i < 4; i++){
                nx = now.x + dx[i];
                ny = now.y + dy[i];

                if(!is_boundary(nx, ny) || visited[nx][ny]) continue;
                if(map[nx][ny] == 0) {
                    visited[nx][ny] = true;
                    q.add(new node(nx, ny));
                }else {
                    visited[nx][ny] = true;
                    melt.add(new node(nx, ny));
                }
            }
        }

        int melt_size = melt.size();
        for(node cur : melt){
            map[cur.x][cur.y] = 0;
        }
        return melt_size;
    }

    static boolean is_boundary (int x, int y){
        if(x < 0 || n <= x || y < 0 || m <= y) return false;
        return true;
    }


    static void pre_setting() throws Exception{
        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];

        int x, y;
        for(int i = 0; i < n; i++){

            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 1) total++;
            }
        }
    }

    static class node{
        int x, y;
        node(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}