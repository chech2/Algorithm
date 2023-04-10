import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int [][] map = new int[10][10];
    static int paper[] = new int[5 + 1];
    static int result = Integer.MAX_VALUE;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        for (int i = 0; i < 10; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 10; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 1) map[i][j] = -1;
            }
        }

        /////////입력 완료//////////////

        dfs(0,0);
        if(result == Integer.MAX_VALUE) result = -1;
        System.out.println(result);
    }

    static void dfs(int x, int y){
        if(y >= 10){
            dfs(x + 1, 0);
            return;
        }

        if(x >= 10) {
            if(check(0,0, 10) != 0) return;
            result = Math.min(sum(), result);
            return;
        }
        if(map[x][y] == 0){
            dfs(x, y + 1);
        }
        if(map[x][y] == -1){
            for (int k = 5; 0 < k; k--) {

                if(paper[k] >= 5) continue;

                if(x + k > 10 || y + k > 10) continue;

                if(check(x, y, k) != k * k) continue;
//                System.out.println("x: " + x + " y: " + y + " tmp: " +  check(x, y, k));
                paper[k]++;
                fill(x, y, 0, k);
//                print();
                dfs(x, y + 1);
                fill(x, y, -1, k);
                paper[k]--;

            }
        }
    }

    static int sum(){
        int ans = 0;
        for (int i = 1; i < 6; i++) {
            ans += paper[i];
        }
        return ans;
    }

    static void fill(int x, int y, int num, int W){
        for (int i = x; i < x + W; i++) {
            for (int j = y; j < y + W; j++) {
                map[i][j] = num;
            }
        }
    }

    static int check(int x, int y, int W){
        //정사각형 모양인지 확인하기
        //세로 확인
        int result = 0;
        for (int i = x; i < x + W; i++) {
            for (int j = y; j < y + W; j++) {
                if(map[i][j] == -1) result++;
            }
        }
        return result;
    }

    static void print(){
        //정사각형 모양인지 확인하기
        //세로 확인
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}