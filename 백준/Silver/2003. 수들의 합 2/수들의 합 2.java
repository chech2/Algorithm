import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N, M, ans;
    static int [] numbers;
    static boolean visited[];
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        numbers = new int[N];
        visited = new boolean[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i <= N ; i++) {
            subset(i);
        }
        System.out.println(ans);
    }

    static void subset(int size){
        int result = 0, start = 0, cnt = 0;
        for (int i = 0; i < N; i++) {
            cnt++;
            if(cnt < size)
                result += numbers[i];
            else{
                result += numbers[i];
                if(result == M) ans++;
                result -= numbers[start];

                start++;
            }
        }

    }
}