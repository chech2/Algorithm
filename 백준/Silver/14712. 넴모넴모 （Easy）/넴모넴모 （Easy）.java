import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    //우,하, 오른쪽 대각선
    static int next[][] = new int [3][3];

    static int visited[][];
    static int N, M, AllNum, Case4Num;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        visited = new int[N][M];
        next[0] = new int[] {0, -1}; //왼쪽
        next[1] = new int[] {-1, 0}; //위쪽
        next[2] = new int[] {-1, -1};//위로 왼쪽 대각선
        AllCases(0);

        System.out.println(Case4Num);

    }


    //어떤 네모가 배열에 다 놓여진 경우
    private static void AllCases(int cnt) {
        if(cnt == N  * M) {
            Case4Num++;
            return;
        }

        int x = cnt / M;
        int y = cnt % M;
//        System.out.println("x: " +x +  " y: " + y + " cnt: " + cnt);

        int tmp = 0;
        for (int i = 0; i < 3; i++) {
            int nx = x + next[i][0];
            int ny = y + next[i][1];

            if(0 <= nx && nx < N && 0 <= ny && ny < M) {
                if(visited[nx][ny] == 1) {
//                    System.out.println("nx: " +nx +  " ny: " + ny + " cnt: " + cnt + " tmp: " + tmp);

                    tmp++;
                }
            }
        }
        if(tmp == 3) {
            AllCases(cnt + 1);
        }else {
            visited[x][y] = 1;
            AllCases(cnt + 1);
            visited[x][y] = 0;
            AllCases(cnt + 1);
        }
    }
}