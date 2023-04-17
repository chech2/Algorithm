import java.util.ArrayList;
import java.util.Scanner;

//퀸의 이동 가능 방향, 4방, 대각선
// 이동이 가능한지 체크 (가로, 세로, 대각선 X) => 가능하면 놓고 불가능하면 백트레킹

public class Main {
    static ArrayList<Integer> chessX = new ArrayList<>();
    static ArrayList<Integer> chessY = new ArrayList<>();

    static int N, result;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
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
            if (!chessY.contains(j) && dia(depth, j)) {
                chessX.add(depth);
                chessY.add(j);
                dfs(depth + 1);
                int x = chessX.indexOf(depth);
                int y = chessY.indexOf(j);
                chessX.remove(x);
                chessY.remove(y);
            }
        }
    }
    
    static boolean dia(int r, int c){
        //대각선 체크
        for (int i = 0; i < chessX.size(); i++) {
            if(Math.abs(r - chessX.get(i)) == Math.abs(c - chessY.get(i)))
                return false;
        }
        return true;
    }
}