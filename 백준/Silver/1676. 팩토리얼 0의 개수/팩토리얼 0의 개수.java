import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    static int N;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        N /= 5;

        if(N < 5)
            System.out.println(N);
        else if(5 <= N && N < 25)
            System.out.println(N +  N / 5);
        else
            System.out.println(N + N / 5 + N / 25);
    }
}