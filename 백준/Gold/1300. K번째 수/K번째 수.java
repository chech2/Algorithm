import java.io.*;
import java.util.*;
public class Main {
    static int n, k;
    static int[] numbers;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws Exception{
        input();
        System.out.println(binarySearch());
    }

    public static int binarySearch(){
        int s, e, m, cnt;
        s = 1;
        e = k;

        while(s <= e){
            m = (s + e) / 2;
            cnt = 0;
            for (int i = 1; i < n + 1; i++) cnt += Math.min(m / i, n);

            if(cnt < k) s = m + 1;
            else e = m - 1;
        }
        return s;
    }

    public static void input() throws Exception{
        n = Integer.parseInt(br.readLine());
        k = Integer.parseInt(br.readLine());
    }
}