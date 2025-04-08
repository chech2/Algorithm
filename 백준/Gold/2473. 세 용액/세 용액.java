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
        test();
        bw.append(String.valueOf(seleted[0])).append(" ").append(String.valueOf(seleted[1])).append(" ").append(String.valueOf(seleted[2]));

        bw.close();
    }

    static void test(){
        long sum, tmp;

        for(int i = 0; i < n - 2; i++){

            for(int j = i + 1; j < n - 1; j++){
                sum = liquid[i] + liquid[j];
                tmp = search(j + 1, sum);

                sum += tmp;

                if(Math.abs(sum) < Math.abs(ans)) {
                    ans = sum;
                    seleted[0] = liquid[i];
                    seleted[1] = liquid[j];
                    seleted[2] = tmp;
                }
            }
        }
    }

    static long search(int s, long sum){
        int e, m;
        long tmp = INF;
        e = n - 1;
        m = 0;

        while(s <= e){
            m = (s + e) / 2;

            if (sum + liquid[m] < 0) s = m + 1;
            else if (0 < sum + liquid[m]) e = m - 1;
            else return liquid[m];
            if(Math.abs(sum + liquid[m]) < Math.abs(sum + tmp)) tmp = liquid[m];
        }
        return tmp;
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