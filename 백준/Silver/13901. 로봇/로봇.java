import java.io.*;
import java.util.*;

public class Main {
    static int r, c, k;
    static int[] d, robot;
    static boolean[][] trap;
    static int[] dx = {0, -1, 1, 0, 0};
    static int[] dy = {0, 0, 0, -1, 1};
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws Exception{
        preSetting();
        move();
        sb.append(robot[0]).append(" ").append(robot[1]);
        bw.append(sb);
        bw.close();
    }

    static void move(){

        int nx, ny, idx, combo;

        idx = 0;
        combo = 0;

        while(combo < 4){
            nx = robot[0] + dx[d[idx]];
            ny = robot[1] + dy[d[idx]];

            if(nx < 0 || ny < 0 || r <= nx || c <= ny || trap[nx][ny]) {
                idx++;
                if(idx == 4) idx = 0;
                combo++;
                continue;
            }
            trap[nx][ny] = true;
            robot[0] = nx;
            robot[1] = ny;
            combo = 0;
        }
    }

    static void preSetting() throws Exception{
        st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(br.readLine());

        trap = new boolean[r][c];
        robot = new int[2];
        d = new int[4];

        int x, y;
        for(int i = 0; i < k; i++){
            st = new StringTokenizer(br.readLine());

            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());

            trap[x][y] = true;
        }

        st = new StringTokenizer(br.readLine());

        robot[0] = Integer.parseInt(st.nextToken());
        robot[1] = Integer.parseInt(st.nextToken());
        trap[robot[0]][robot[1]] = true;

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < 4; i++) d[i] = Integer.parseInt(st.nextToken());
    }
}