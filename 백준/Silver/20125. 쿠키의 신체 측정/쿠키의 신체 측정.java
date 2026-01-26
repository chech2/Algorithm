import java.io.*;

public class Main {

    static String BODY = "*";
    static int n;
    static int[] heart;
    static int[][] map;
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception {
        preSetting();
        findHeart();
        sb.append(heart[0] + 1).append(" ").append(heart[1] + 1).append("\n");

        calLen(heart[0], heart[1]);
        System.out.println(sb.toString());
    }

    private static void calLen(int sX, int sY){
        int ans, m;

        // 허리
        m = 0;
        for (int i = sX + 1; i < n; i++) {
            if (map[i][sY] == 1) {
                m++;
            } else {
                heart[0] = i;
                break;
            }
        }

        ans = 0;
        for(int i = sY - 1; 0 <= i; i--){
            if (map[sX][i] == 1) {
                ans++;
            } else {
                break;
            }
        }
        sb.append(ans).append(" ");

        ans = 0;
        for(int i = sY + 1; i < n; i++){
            if (map[sX][i] == 1) {
                ans++;
            } else {
                break;
            }
        }
        sb.append(ans).append(" ");
        sb.append(m).append(" ");

        ans = 0;
        for(int i = sX + m + 1; i < n; i++){
            if (map[i][sY - 1] == 1) {
                ans++;
            } else {
                break;
            }
        }
        sb.append(ans).append(" ");

        ans = 0;
        for(int i = sX + m + 1; i < n; i++){
            if (map[i][sY + 1] == 1) {
                ans++;
            } else {
                break;
            }
        }
        sb.append(ans).append(" ");
    }

    private static void findHeart(){
        for(int i = 1; i < n - 1; i++){
            for(int j = 0; j < n - 1; j++){
                if(isHeart(i, j)) {
                    heart[0] = i;
                    heart[1] = j;
                    return;
                }
            }
        }
    }

    private static boolean isHeart(int x, int y) {
        if (x - 1 < 0) {
            return false;
        }

        if (map[x - 1][y] == 1) {
            if (x - 2 < 0) {
                return true;
            } else if (map[x - 2][y] == 0) {
                return true;
            }
        }
        return false;
    }

    private static void preSetting() throws Exception {
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        heart = new int[2];

        String now[];
        for (int i = 0; i < n; i++) {
            now = br.readLine().split("");

            for (int j = 0; j < n; j++) {
                if (now[j].equals(BODY)) {
                    map[i][j] = 1;
                } else {
                    map[i][j] = 0;
                }
            }
        }
    }
}
