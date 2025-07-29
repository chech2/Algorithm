import java.io.*;
import java.util.*;

public class Main {
    static int[] num, qList;
    static int N, M;
    static StringBuilder sb;
    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws Exception{
        inputSetting();
        for(int i = 0; i < M; i++) sb.append(binarySearch(qList[i])).append("\n");

        bw.append(sb);
        bw.close();
    }

    static int binarySearch(int find){
        int l, r, m;

        l = 0;
        r = N - 1;

        while(l <= r){
            m = (l + r) / 2;

            if(num[m] == find) return 1;
            if(num[m] < find){
                l = m +  1;
            }else if(find < num[m]){
                r = m - 1;
            }
        }
        return 0;
    }

    static void inputSetting() throws Exception{
        sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        num = new int[N];

        st = new StringTokenizer (br.readLine());
        for(int i = 0; i < N; i++) num[i] = Integer.parseInt(st.nextToken());

        M = Integer.parseInt(br.readLine());
        qList = new int[M];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < M; i++) qList[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(num);
    }
}