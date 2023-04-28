import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    //동서북남
    static int dx[] = {0, 0, 0, -1, 1};
    static int dy[] = {0, 1, -1, 0, 0};

    static int N, M, diceX, diceY, K;
    static int map[][];
    static int dir[];
    static int dice[] = {0,0,0,0,0,0,0};

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        diceX = Integer.parseInt(st.nextToken());
        diceY = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        dir = new int[K];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < K; i++) {
            dir[i] = Integer.parseInt(st.nextToken());
        }
        MoveDice();
    }

    private static void MoveDice() {
        int NowDir;
        int x = diceX, y = diceY;

        for (int i = 0; i < K; i++) {
            NowDir = dir[i];
            int nextX = dx[NowDir];
            int nextY = dy[NowDir];

            //갈 수 없는 위치인 경우
            if(x + nextX < 0 || x + nextX >= N || y + nextY < 0 || y + nextY >= M) continue;
            x += nextX;
            y += nextY;
            int tmp[] = dice.clone();

            //주사위 굴리기
            if(NowDir == 1){
                dice[1] = tmp[4];
                dice[3] = tmp[1];
                dice[4] = tmp[6];
                dice[6] = tmp[3];

            }else if (NowDir == 2) {
                dice[1] = tmp[3];
                dice[3] = tmp[6];
                dice[4] = tmp[1];
                dice[6] = tmp[4];

            }else if(NowDir == 3){
                dice[1] = tmp[5];
                dice[2] = tmp[1];
                dice[5] = tmp[6];
                dice[6] = tmp[2];

            }else{
                dice[1] = tmp[2];
                dice[2] = tmp[6];
                dice[5] = tmp[1];
                dice[6] = tmp[5];
            }
            //이동한 칸의 수가 0
            if(map[x][y] == 0){
                map[x][y] = dice[6];
            }else{
                dice[6] = map[x][y];
                map[x][y] = 0;
            }
            System.out.println(dice[1]);
        }
    }
}