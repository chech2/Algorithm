import java.io.*;
import java.util.*;

public class Main {

    static int n, m;
    static int[] cards, finds;
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws Exception{
        pre_setting();
        for(int i = 0; i < m; i++){
            sb.append(binary_search(finds[i])).append(" ");
        }
        bw.append(sb);
        bw.close();
    }

    static int binary_search(int numbers){
        int s, e, m;
        s = 0;
        e = n - 1;

        while(s <= e){
            m = (s + e) / 2;

            if(cards[m] == numbers) return 1;

            if(cards[m] < numbers){
                s = m + 1;
            }else{
                e = m - 1;
            }
        }
        return 0;
    }

    static void pre_setting() throws Exception{
        n = Integer.parseInt(br.readLine());
        cards = new int[n];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) cards[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(cards);

        m = Integer.parseInt(br.readLine());
        finds = new int[m];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < m; i++) finds[i] = Integer.parseInt(st.nextToken());

    }

}