import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    //북동남서
    static int dx[] = {-1, 0, 1, 0};
    static int dy[] = {0, 1, 0, -1};
    static int map[][];
    static Queue<posi> Lot = new ArrayDeque<>();
    static ArrayDeque<snake> snakes = new ArrayDeque<>(); //뱀의 형상을 저장

    static int N, appleNum, LotCnt;
    static class posi{
        int time;
        String dir;

        public posi(int time, String dir){
            this.time = time;
            this.dir = dir;
        }
    }

    static class snake{
        int r, c; //뱀의 시작지점

        public snake(int r, int c){
            this.r = r; // 뱀의 시작
            this.c = c; //뱀의 시작
        }
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        N = Integer.parseInt(br.readLine());
        appleNum = Integer.parseInt(br.readLine());
        map = new int[N][N];

        for (int i = 0; i < appleNum; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken()) - 1;
            map[r][c] = 2;
        }
        LotCnt = Integer.parseInt(br.readLine());

        for (int i = 0; i < LotCnt; i++) {
            st = new StringTokenizer(br.readLine());
            int time = Integer.parseInt(st.nextToken());
            String dir = st.nextToken();
            Lot.add(new posi(time, dir));
        }


        map[0][0] = 1;
        int dir = 1;
        int cnt = 0;
        snakes.add(new snake(0,0));
        posi Lotime = Lot.poll();

        while (true){
            cnt++;
            //뱀의 머리위치
            snake now = snakes.poll();

            int r = now.r + dx[dir];
            int c = now.c + dy[dir];

            //벽과 만난 경우 or 자신의 몸과 부딪히는 경우
            if(r < 0 || r >= N || c < 0 || c >= N) break;
            if(map[r][c] == 1) break;

            snakes.addFirst(new snake(now.r, now.c));
            snakes.addFirst(new snake(r, c));

            //사과가 있는 경우
            if(map[r][c] == 2) {
                map[r][c] = 1;
            }else{
                map[r][c] = 1;
                snake last = snakes.pollLast();
                map[last.r][last.c] = 0;
            }
            //방향 전환
            if(Lotime != null && cnt == Lotime.time){
                if(Lotime.dir.equals("D")){
                    dir = (dir + 1) % 4;
                }
                else {
                    dir = (dir + 3) % 4;
                }

                Lotime = Lot.poll();
            }
        }
        System.out.println(cnt);
    }
}