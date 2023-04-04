import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    static int N;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        int result = (N / 5) + N/25 + N/125;
        System.out.println(result);
    }
}