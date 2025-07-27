import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int[] one, two;
    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws Exception{
        inputSetting();
        System.out.println(Math.max(kadane_algo(one), kadane_algo(two)));
    }

    static int kadane_algo(int[] arr){
        int max = 0;
        int cur = 0;

        for(int i = 0; i < n; i++){
            cur = Math.max(arr[i], cur + arr[i]);
            max = Math.max(max, cur);
        }

        return max;
    }

    static void inputSetting() throws Exception{
        n = Integer.parseInt(br.readLine());
        one = new int[n];
        two = new int[n];

        int now;
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            now = Integer.parseInt(st.nextToken());

            if(now == 1){
                one[i] = 1;
                two[i] = -1;
            } else{
                one[i] = -1;
                two[i] = 1;
            }
        }
    }
}