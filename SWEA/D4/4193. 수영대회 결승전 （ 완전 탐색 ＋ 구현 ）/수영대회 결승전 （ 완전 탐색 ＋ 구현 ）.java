import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {

    //상하좌우
    static int dx[] = {-1,1,0,0};
    static int dy[] = {0,0,-1,1};

    static int TC, N, TIME;
    static int map[][], info[][];
    static boolean visited[][];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        TC = Integer.parseInt(br.readLine());

        for (int t = 1; t <= TC; t++) {
            StringTokenizer st;
            N = Integer.parseInt(br.readLine());
            TIME = 700;
            map = new int[N][N];
            info = new int[2][2];
            visited = new boolean[N][N];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            for (int i = 0; i < 2; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < 2; j++) {
                    info[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            bfs();

            if(TIME != 700)
                sb.append("#").append(t).append(" ").append(TIME).append("\n");
            else
                sb.append("#").append(t).append(" -1\n");
        }
        System.out.println(sb);
    }

    static void bfs(){
        int startX = info[0][0];
        int startY = info[0][1];

        Queue<Node> q = new ArrayDeque<>();
        q.add(new Node(startX, startY, 0));
        visited[startX][startY] = true;

        while(!q.isEmpty()){
            Node now = q.poll();
            if(now.x == info[1][0] && now.y == info[1][1]){
                TIME = Math.min(TIME, now.time);
                //break;
            }
            for (int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];
                int time = now.time;

                //배열 범위 밖 or 이미 방문한 곳
                if(0 > nx || nx >= N || 0 > ny || ny >= N || visited[nx][ny]) continue;

                //물
                if(map[nx][ny] == 1) continue;

                //가는 곳에 소용돌이가 발생하는 경우
                if(map[nx][ny] == 2 && time % 3 != 2) {
                    //visited[nx][ny] = true;
                    //if ((time - 2) % 3 == 0)
                        //q.add(new Node(now.x, now.y, time + 1));
                    //if ((time - 2) % 3 == 1)
                        q.add(new Node(now.x, now.y, time + 1));

                }else {
                    visited[nx][ny] = true;
                    q.add(new Node(nx, ny, time + 1));
                }
            }
        }
    }

    static class Node{
        int x;
        int y;
        int time;

        Node(int x, int y, int time){
            this.x = x;
            this.y = y;
            this.time = time;
        }
    }


}