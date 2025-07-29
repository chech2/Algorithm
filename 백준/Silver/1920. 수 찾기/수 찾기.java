import java.io.*;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws Exception{
        int N, M, find;

        N = Integer.parseInt(br.readLine());
        HashSet<Integer> set = new HashSet<>();

        st = new StringTokenizer (br.readLine());
        for(int i = 0; i < N; i++) set.add(Integer.parseInt(st.nextToken()));

        M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < M; i++){
            find = Integer.parseInt(st.nextToken());

            if(set.contains(find)) bw.append('1');
            else bw.append('0');

            bw.append('\n');
        }

        bw.close();
    }
}