import java.io.*;
import java.util.*;
public class Main {
    static boolean flag;
    static int[] cm, selected;
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws Exception {
        pre_setting();
        combi(0, 0, 0);
        bw.append(sb);
        bw.close();

    }

    static void combi(int cnt, int sum, int start){
        if(cnt == 7){
            if(sum == 100 && !flag){
                for(int i = 0; i < 7; i++) sb.append(selected[i]).append("\n");
                flag = true;
            }
            return;
        }
        for(int i = start; i < 9; i++){
            selected[cnt] = cm[i];
            combi(cnt + 1, sum + cm[i], i + 1);
        }
    }

    static void pre_setting() throws Exception{
        cm = new int[9];
        selected = new int[7];

        for(int i = 0; i < 9; i++) cm[i] = Integer.parseInt(br.readLine());
        Arrays.sort(cm);
    }

}