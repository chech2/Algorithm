import java.io.*;
import java.util.*;

public class Main {

    static long x, y, z, a;
    public static void main(String[] args) throws Exception {
        preSetting();
        if(z != 100) a = binarySearch();
        else a = -1;

        System.out.println(a);
    }

    private static long binarySearch(){
        long s = 0, e = x;
        long m, cal;
        long result = Integer.MAX_VALUE;
        while(s <= e) {
            m = (s + e) / 2;
            cal = (y + m) * 100 / (x + m);

            if(z < cal){
                result = Math.min(result, m);
                e = m - 1;
            } else {
                s = m + 1;
            }
        }
        if(result == Integer.MAX_VALUE) result = -1;
        return result;
    }

    private static void preSetting() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
        z = (y * 100 / x);
    }
}
