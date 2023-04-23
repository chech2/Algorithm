import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int k;
    static int[] numbers, seleted;
    static StringBuilder sb = new StringBuilder();


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true){
            StringTokenizer st = new StringTokenizer(br.readLine());
            k = Integer.parseInt(st.nextToken());
            if(k == 0) break;

            numbers = new int[k];
            seleted = new int[6];
            for (int i = 0; i < k; i++) {
                numbers[i] = Integer.parseInt(st.nextToken());
            }
            combi(0, 0);
            sb.append("\n");
        }
        System.out.println(sb);
    }
    static void combi(int start, int cnt){
        if(cnt == 6){
            for (int i = 0; i < 6; i++)
                sb.append(seleted[i]).append(" ");

            sb.append("\n");
            return;
        }
        for (int i = start; i < k; i++) {
            seleted[cnt] = numbers[i];
            combi(i + 1, cnt + 1);
        }
    }
}