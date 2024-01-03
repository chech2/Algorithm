import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class Main {

    static long k, cnt;
    static ArrayDeque<Long> list = new ArrayDeque<>();
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        k = Long.parseLong(br.readLine());

        for(long i = 2; i * i <= k; i++){
            while (k % i == 0) {
                k /= i;
                cnt++;
                list.add(i);
            }
        }

        if (k != 1) {
            cnt++;
            list.add(k);
        }

        sb.append(cnt).append("\n");
        while (!list.isEmpty())sb.append(list.poll()).append(" ");
        System.out.println(sb);
    }

}