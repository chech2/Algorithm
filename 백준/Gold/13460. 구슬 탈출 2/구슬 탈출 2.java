import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    //왼, 하, 오, 상
    static int dx[] = {0,1,0,-1};
    static int dy[] = {-1,0,1,0};

    static char[][] origin;
    static boolean[][][][] visit;
    static Queue<marble> q;
    static int[] Hole;
    static int bx, by, rx, ry,  N, M, ans;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        q = new ArrayDeque<>();
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        origin = new char[N][M];
        visit = new boolean[N][M][N][M];
        Hole = new int[2];
        ans = Integer.MAX_VALUE;

        for (int i = 0; i < N; i++) {
            origin[i] = br.readLine().toCharArray();
            for (int j = 0; j < M; j++) {
                if(origin[i][j] == 'R'){
                    rx = i;
                    ry = j;
                }
                else if(origin[i][j] == 'B') {
                    bx = i;
                    by = j;
                }
                else if(origin[i][j] == 'O'){
                    Hole[0] = i;
                    Hole[1] = j;
                }
            }
        }
        visit[rx][ry][bx][by] = true;
        q.offer(new marble(rx, ry, bx, by, 1));

        while (!q.isEmpty()){
            marble now = q.poll();
            if(now.time > 10) break;

            for (int i = 0; i < 4; i++) {
                boolean isRedHole = false;
                boolean isBlueHole = false;

                int NX = dx[i];
                int NY = dy[i];

                //현재 구슬의 좌표
                int RX = now.Rx;
                int RY = now.Ry;
                int BX = now.Bx;
                int BY = now.By;

                //빨간 구슬 옮기기
                while (origin[RX + NX][RY + NY] != '#'){
                    RX += NX;
                    RY += NY;
                    if(RX == Hole[0] && RY == Hole[1]){
                        isRedHole = true;
                        break;
                    }
                }
                //파란 구슬 옮기기
                while (origin[BX + NX][BY + NY] != '#'){
                    BX += NX;
                    BY += NY;
                    if(BX == Hole[0] && BY == Hole[1]){
                        isBlueHole = true;
                        break;
                    }
                }
                ////////////구슬 옮기기 종료/////////////////
                if(isBlueHole) continue;

                if(isRedHole && !isBlueHole){
                    ans = Math.min(ans, now.time);
                    break;
                }

                ///////////같은 위치에 구슬이 옮겨진 경우///////////////
                if(RX == BX && RY == BY){
                    if(i == 0){ // 왼
                        if(now.Ry > now.By) RY += 1;
                        else BY += 1;

                    }else if(i == 1){ // 하
                        if(now.Rx > now.Bx) BX -= 1;
                        else RX -= 1;

                    }else if(i == 2){ // 오
                        if(now.Ry < now.By) RY -= 1;
                        else BY -= 1;

                    }else{ // 상
                        if(now.Rx > now.Bx) RX += 1;
                        else BX += 1;
                    }
                }

                if (!visit[RX][RY][BX][BY]){
                    visit[RX][RY][BX][BY] = true;
                    q.offer(new marble(RX,RY,BX,BY, now.time + 1));
                }
            }
        }
        if(ans == Integer.MAX_VALUE)
            System.out.println(-1);
        else
            System.out.println(ans);
    }

    static class marble{
        int Rx, Ry, Bx, By, time;

        marble(int Rx, int Ry, int Bx, int By, int time){
            this.Rx = Rx;
            this.Ry = Ry;
            this.Bx = Bx;
            this.By = By;
            this.time = time;
        }
    }
}