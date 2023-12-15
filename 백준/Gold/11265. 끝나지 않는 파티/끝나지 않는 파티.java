import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] map;
    static int N, M, nowParty, nextParty, limitTime;
    static final String ENJOY_OTHER_PARTY = "Enjoy other party";
    static final String STAY_HERE = "Stay here";

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N + 1][N + 1];

        for (int i = 1; i < N + 1; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j < N + 1; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int k = 1; k < N + 1; k++) {
            for (int i = 1; i < N + 1; i++) {
                if(k == i) continue;
                for (int j = 1; j < N + 1; j++) {
                    if(j == k || i == j) continue;
                    map[i][j] = Math.min(map[i][j], (map[i][k] + map[k][j]));
                }
            }
        }

        for (int i = 1; i < M + 1; i++) {
            st = new StringTokenizer(br.readLine());
            nowParty = Integer.parseInt(st.nextToken());
            nextParty = Integer.parseInt(st.nextToken());
            limitTime = Integer.parseInt(st.nextToken());

            if(map[nowParty][nextParty] <= limitTime){
                System.out.println(ENJOY_OTHER_PARTY);
            }else {
                System.out.println(STAY_HERE);
            }
        }
    }
}