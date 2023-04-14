import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    /*
        board를 8*8크기로 짤라서 완탐 -> row 0~8까지 col 1개씩 증가시키면서 다 체크 했으면 row + 1
        체크함수 dfs

    */

    //상하좌우
    static int dx[] = {-1,1,0,0};
    static int dy[] = {0,0,-1,1};
    static boolean visited[][], checking[][];
    static int R, C, ans;
    static char board[][];//, chess[][];
    static Queue<Character> chess;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        ans = Integer.MAX_VALUE;
        board = new char[R][C];

        for (int i = 0; i < R; i++) {
            board[i] = br.readLine().toCharArray();
        }

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                boardcopy(i, j);
            }
        }
        System.out.println(ans);

    }

    static void boardcopy(int row, int col){
        if(row + 7 >= R || col + 7 >= C) return;
        chess = new ArrayDeque<>();

        for (int r = row, i = 0; i < 8; i++, r++) {
            //짝수행
            if(r % 2 == 0){
                for (int c = col, j = 0; j < 8; j++, c++)
                    chess.add(board[r][c]);
            }
            //홀수행
            else{
                for (int c = col + 7, j = 0; j < 8; j++, c--)
                    chess.add(board[r][c]);
            }
        }
        check();
    }

    static void check(){
        int tmp = 0, idx = 1;

        char start = chess.poll();
        while(!chess.isEmpty()){
            char now = chess.poll();
            //짝수
            if(idx % 2 == 0) {
                if (start != now)
                    tmp++;
            }
            else {
                if (start == now)
                    tmp++;
            }
            idx++;
        }
        int tmp2 = 64 - tmp;
        ans = Math.min(Math.min(ans, tmp), tmp2);
    }
}