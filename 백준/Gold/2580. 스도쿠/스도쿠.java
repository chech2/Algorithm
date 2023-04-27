import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int map[][];
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        map = new int[9][9];
        for (int i = 0; i < 9; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 9; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

//        for (int i = 0; i < 9; i++) {
//            for (int j = 0; j < 9; j++) {
//                System.out.println(i + " " + j + "    " +(i - i % 3) + " " + (j - j % 3));
//            }
//        }
        sudoku(0,0);
    }

    public static void sudoku(int N, int M){
        if(M >= 9){
            sudoku(N + 1, 0);
            return;
        }
        if(N >= 9){
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    sb.append(map[i][j]).append(" ");
                }
                sb.append("\n");
            }
            System.out.println(sb);
            System.exit(0);
        }

        if(map[N][M] == 0) {
            for (int num = 1; num < 10; num++) {
                if (RowCheck(N, num) && ColCheck(M, num) && threeCheck(N - N % 3 , M - M % 3, num)) {
                    map[N][M] = num;
                    sudoku(N, M + 1);
//                    map[N][M] = 0;
                }
            }
            //여기까지 왔다?? => 이전 결과들로는 해결이 안된다.
            map[N][M] = 0;
            return;
        }
        sudoku(N, M + 1);
    }


    //행 체크
    public static boolean RowCheck(int row, int num){
        for (int i = 0; i < 9; i++) {
            if(map[row][i] == num) return false;
        }
        return true;
    }

    //열 체크
    public static boolean ColCheck(int col, int num) {
        for (int i = 0; i < 9; i++) {
            if (map[i][col] == num) return false;
        }
        return true;
    }

    //3x3체크
    public static boolean threeCheck(int N, int M, int num){
        for (int i = N; i < N + 3; i ++) {
            for (int j = M; j < M + 3; j++) {
                if(map[i][j] == num) return false;
            }
        }
        return true;
    }
}