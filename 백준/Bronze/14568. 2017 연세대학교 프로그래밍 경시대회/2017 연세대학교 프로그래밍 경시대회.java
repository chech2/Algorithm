import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.Buffer;

public class Main {
    static int a, b, c, candy, cnt;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception{
        candy = Integer.parseInt(br.readLine());

        // i: 남규, j: 영훈, k: 택희
        // 택희는 짝수, 남규는 영훈보다 2개 많기
        for (int i = 1; i < candy - 2; i++) {
            for (int j = 1; j < candy - 2; j++) {
                for (int k = 2; k < candy - 2; k += 2) {
                    if(k % 2 == 1) continue;
                    if(i < j + 2) continue;
                    if(k + i + j != candy) continue;
                    cnt++;
                }
            }
        }
        System.out.println(cnt);
    }
}