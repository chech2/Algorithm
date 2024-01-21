import java.util.*;
import java.io.*;

public class Main {
    static int n, m, idx;
    static int[] arr;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n + m];

        inputSetting(n, new StringTokenizer(br.readLine()));
        inputSetting(m, new StringTokenizer(br.readLine()));
        Arrays.sort(arr);
        for (int i = 0; i < n + m; i++) {
            bw.append(arr[i] + " ");
        }
        bw.flush();
        bw.close();
    }

    public static void inputSetting(int size, StringTokenizer st){
        for (int i = 0; i < size; i++) {
            arr[idx] = Integer.parseInt(st.nextToken());
            idx++;
        }
    }
}