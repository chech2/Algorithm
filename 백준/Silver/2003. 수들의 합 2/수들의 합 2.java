import java.io.*;
import java.util.*;
public class Main {
    static int n, m;
    static int[] arr, s;
    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws Exception{
        input();
        System.out.println(towPoint());
    }

    public static int towPoint() {
        int start, end, cnt, sum;
        start = 0;
        end = 1;
        cnt = 0;
//        System.out.println(Arrays.toString(s));
        while(start < n){
            sum = s[end] -  s[start];
//            System.out.println(start + " " + end + "  >>  " + sum);

            if(sum < m){
                if(end < n) end++;
                else start++;
            }else if(m < sum){
                start++;
            }else{
                cnt++;
                if(end < n) end++;
                else start++;
            }
        }
        return cnt;
    }

    public static void input() throws Exception{
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n];
        s = new int[n + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            s[i + 1] = arr[i] + s[i];
        }
    }

}