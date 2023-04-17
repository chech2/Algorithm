import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

//퀸의 이동 가능 방향, 4방, 대각선
// 이동이 가능한지 체크 (가로, 세로, 대각선 X) => 가능하면 놓고 불가능하면 백트레킹

public class Main {
    static int[] chess;
//    static ArrayList<Integer> chessY = new ArrayList<>();

    static int N, result;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        chess = new int[N];
        Arrays.fill(chess, -1);
        dfs(0);
        System.out.println(result);
    }

    static void dfs(int depth) {
        if (depth >= N) {
            result++;
            return;
        }

        //depth 행에서 1개 선택하기
        for (int j = 0; j < N; j++) {
            if (dia(depth, j)) {
                chess[depth] = j;
                dfs(depth + 1);
                chess[depth] = -1;
            }
        }
    }

    static boolean dia(int r, int c){
        //열 체크
        for (int i = 0; i < N; i++) {
            if(chess[i] == c) return false;
        }

        //대각선 체크
        for (int i = 0; i < N; i++) {
            if(chess[i] == -1)continue;
            if(Math.abs(r - i) == Math.abs(c - chess[i])) return false;
        }
        return true;
    }
}