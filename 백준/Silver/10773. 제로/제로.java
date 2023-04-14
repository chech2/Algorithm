import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

    static long result;
    static int k;
    static Stack<Integer> s = new Stack<>();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        k = Integer.parseInt(br.readLine());
        for (int i = 0; i < k; i++) {
            int tmp = Integer.parseInt(br.readLine());
            if(tmp == 0)
                s.pop();
            else
                s.add(tmp);
        }
        while (!s.isEmpty()){
            result += s.pop();
        }
        System.out.println(result);

    }
}