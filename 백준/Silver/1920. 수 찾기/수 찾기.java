import java.io.*;
import java.util.*;

public class Main {
    static Set<Integer> set;
    static int[] qList;
    static int N, M;
    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws Exception{
        inputSetting();
        for(int i = 0; i < M; i++){
            if(set.contains(qList[i])) bw.append('1');
            else bw.append('0');
            
            bw.append('\n');
        }

        bw.close();
    }

    static void inputSetting() throws Exception{
        N = Integer.parseInt(br.readLine());
        set = new HashSet<>();

        st = new StringTokenizer (br.readLine());
        for(int i = 0; i < N; i++) set.add(Integer.parseInt(st.nextToken()));

        M = Integer.parseInt(br.readLine());
        qList = new int[M];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < M; i++) qList[i] = Integer.parseInt(st.nextToken());
    }
}