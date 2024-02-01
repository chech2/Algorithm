import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n, s, ans;
    static int[] number;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());

        number = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            number[i] = Integer.parseInt(st.nextToken());
        }

        ans = subset(1, number[0]) + subset(1, 0);

        if(s == 0) ans--;
        System.out.println(ans);
    }
    public static int subset(int cnt, int num){
        if(cnt == n){
            if(s == num) return 1;
            return 0;
        }

        return subset(cnt + 1, num + number[cnt]) + subset(cnt + 1, num);
    }
}