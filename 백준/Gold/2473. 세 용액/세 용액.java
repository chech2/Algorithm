import java.io.*;
import java.util.*;

public class Main {
    static long INF = 30000000001L;
    static int n;
    static long ans;
    static long[] liquid, seleted;
    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws Exception{
        inputSetting();
        findThreeLiquid();
        bw.append(String.valueOf(seleted[0])).append(" ").append(String.valueOf(seleted[1])).append(" ").append(String.valueOf(seleted[2]));

        bw.close();
    }

    static void findThreeLiquid(){
        for(int i = 0; i < n - 2; i++){
            towPoint(i + 1, liquid[i]);
        }
    }

    static void towPoint(int s, long first){
        long now;
        int e = n - 1;

        while(s < e){
            now = first + liquid[s] + liquid[e];

            if(Math.abs(now) < Math.abs(ans)) {
                ans = now;
                seleted[0] = first;
                seleted[1] = liquid[s];
                seleted[2] = liquid[e];
            }

            if (now < 0) s++;
            else if (0 < now) e--;
            else break;
        }
    }

    static void inputSetting() throws Exception{
        n = Integer.parseInt(br.readLine());
        liquid = new long[n];
        seleted = new long[3];
        ans = INF;

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) liquid[i] = Long.parseLong(st.nextToken());

        Arrays.sort(liquid);
    }
}