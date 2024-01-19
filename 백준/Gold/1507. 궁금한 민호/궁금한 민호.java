import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[][] map, copy;
    static int n, ans;
    static boolean flag;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());

        map = new int[n + 1][n + 1];
        copy = new int[n + 1][n + 1];
        for (int i = 1; i < n + 1; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j < n + 1; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                copy[i][j] = map[i][j];
            }
        }

        for (int k = 1; k < n + 1; k++) {
            for (int i = 1; i < n + 1; i++) {
                for (int j = 1; j < n + 1; j++) {
                    if(k == i || k == j || i == j) continue;
                    //입력된 map이 최단 거리가 아니라는 의미, 뭔가 모순이 존재한다.
                    if(map[i][j] > map[i][k] + map[k][j]) {
                        flag = true;
                        break;
                    }
                    if(map[i][j] == map[i][k] + map[k][j]) copy[i][j] = Integer.MAX_VALUE;
                }
            }
        }
        if (flag) {
            System.out.println(-1);
        }else {
            for (int i = 1; i < n + 1; i++) {
                for (int j = 1; j < n + 1; j++) {
                    if(copy[i][j] != Integer.MAX_VALUE) ans += copy[i][j];
                }
            }
            System.out.println(ans / 2);
        }

    }

}