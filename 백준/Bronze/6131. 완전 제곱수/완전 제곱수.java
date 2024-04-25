import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static int n, cnt;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws Exception{
        n = Integer.parseInt(br.readLine());

        for (int i = 1; i < 501; i++) {
            for (int j = i; j < 501; j++) {
                if(i * i + n == j * j) cnt++;
            }
        }
        System.out.println(cnt);
    }

}