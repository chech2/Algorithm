import javax.swing.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.SQLOutput;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[][] origin;
    static int N, ans;
    //상하좌우
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        origin = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                origin[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        /////////// 입력 완료 ///////////////////
        dfs(0);
        System.out.println(ans);
    }

    static void dfs(int cnt){
        if(cnt > 5) {
            return;
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                ans = Math.max(origin[i][j], ans);
            }
        }

        //map 복사
        int [][]map = new int[N][N];
        for (int i = 0; i < N; i++) {
            map[i] = origin[i].clone();
        }

        for (int i = 0; i < 4; i++) {
            move(i);
            dfs(cnt + 1);
            for (int j = 0; j < N; j++) {
                origin[j] = map[j].clone();
            }
        }
    }

    static void move(int d){
//        System.out.println("================== d = " + d);

        Queue<block> q = fillQ(d);
        boolean visited[][][][] = new boolean[N][N][N][N];

        while (!q.isEmpty()){
            block now = q.poll();

            int x = now.x;
            int y = now.y;
            int nx, ny;

            //배열 범위를 벗어나지 않는 경우에만 블럭 이동
            while (true){
                //다음 이동 위치
                nx = x + dx[d];
                ny = y + dy[d];

                //배열 범위 밖이라면 stop
                if(nx < 0 || nx >= N || ny < 0 || ny >= N) break;

                //합쳐질 가능성이 있는 경우
                if(origin[nx][ny] != 0){
                    //한번도 합쳐지지 않은 경우 (현재의 블럭 & 도착할 곳의 블럭) & 값이 같은 경우

                    if(!visited[x][y][nx][ny] && origin[nx][ny] == origin[x][y]){
//                        visited[x][y] = true;
                        visited[x][y][nx][ny] = true;
                        origin[nx][ny] *= 2;
                        origin[x][y] = 0;
                    }
                    break;
                }else{
                    origin[nx][ny] = origin[x][y];
                    origin[x][y] = 0;
                }
                x = nx;
                y = ny;
            }
        }
//        print();
//        System.out.println();
    }

    private static Queue<block> fillQ(int d) {
        Queue<block> q = new ArrayDeque<>();

        //상
        if(d == 0){
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (origin[j][i] != 0)
                        q.add(new block(j, i, origin[j][i]));
                }
            }
        }
        //하
        else if (d == 1) {
            for (int i = N - 1; 0  <= i ; i--) {
                for (int j = N - 1; 0 <= j ; j--) {
                    if (origin[j][i] != 0)
                        q.add(new block(j, i, origin[j][i]));
                }
            }
        }
        //좌
        else if (d == 2) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if(origin[i][j] != 0)
                        q.add(new block(i, j, origin[i][j]));
                }
            }
        }
        //우
        else{
            for (int i = N - 1; 0 <= i ; i--) {
                for (int j = N - 1; 0 <= j; j--) {
                    if (origin[i][j] != 0)
                        q.add(new block(i, j, origin[i][j]));
                }
            }
        }
        return q;
    }


    static class block{
        int x, y, size;

        block(int x, int y, int size){
            this.x = x;
            this.y = y;
            this.size = size;
        }
    }

    static void print(){
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(origin[i][j] < 10) System.out.print(" ");
                System.out.print(origin[i][j] + " ");
            }
            System.out.println();
        }
    }
}