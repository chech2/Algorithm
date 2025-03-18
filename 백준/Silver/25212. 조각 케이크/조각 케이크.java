import java.io.*;
import java.util.*;

public class Main{
    static int n, ans, lcd, MIN, MAX;
    static int[] cake;
    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws Exception{
        preSetting();
        recur(0, 0);
        System.out.println(ans);
    }

    static void recur(int cnt, long sum){
        if(cnt == n){
            if(MIN <= sum && sum <= MAX) ans++;
            return;
        }

        recur(cnt + 1, sum);
        recur(cnt + 1, sum + cake[cnt]);
    }

    static void preSetting() throws Exception{
        n = Integer.parseInt(br.readLine());
        cake = new int[n];
        
        st = new StringTokenizer(br.readLine());

        cake[0] = Integer.parseInt(st.nextToken());
        lcd = (100 * cake[0]) / gcd(100, cake[0]);

        for(int i = 1; i < n; i++) {
            cake[i] = Integer.parseInt(st.nextToken());

            lcd = (lcd * cake[i]) / gcd(lcd, cake[i]);
        }
        MIN = 99 * (lcd / 100);
        MAX = 101 * (lcd / 100);


        for(int i = 0; i < n; i++) cake[i] = lcd / cake[i];
    }

    static int gcd(int x, int y){
        int tmp;
        while(x % y != 0){
            tmp = x % y;
            x = y;
            y = tmp;
        }

        return y;
    }
}
