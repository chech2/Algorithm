import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int[] time = new int[1000];
    static int[][] people;
    static int N, result, cnt;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());

        people = new int[N][2];
        for (int i = 0; i < N; i++) {

            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 2; j++) {
                people[i][j] = Integer.parseInt(st.nextToken());
            }
        }


        for (int i = 0; i < N; i++) {
            Arrays.fill(time, 0);

            cnt = 0;
            for (int j = 0; j < N; j++) {
                if(j == i) continue;
                int start = people[j][0];
                int end = people[j][1];
                for (int k = start; k < end; k++) {
                    if(time[k] == 0) {
                        time[k]++;
                        cnt++;
                    }
                }
            }
            result = Math.max(cnt,  result);
        }

        System.out.println(result);
    }
}