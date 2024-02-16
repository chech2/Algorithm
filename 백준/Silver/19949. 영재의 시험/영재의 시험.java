import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int ans;
    static int[] result = new int[10];

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < 10; i++) {
            result[i] = Integer.parseInt(st.nextToken());
        }
        recur(0, -1, -1, 0);
        System.out.println(ans);
    }

    static void recur(int score, int select1, int select2, int cnt){
        if(cnt == 10){
            if(5 <= score) ans++;
            return;
        }

        for (int i = 1; i <= 5; i++) {
            if(select1 == select2 && select1 == i) continue;
            if(i == result[cnt]) recur(score + 1, select2, i, cnt + 1);
            else recur(score, select2, i, cnt + 1);
        }
    }

}