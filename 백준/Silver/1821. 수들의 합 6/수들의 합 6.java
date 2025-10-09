import java.io.*;
import java.util.*;

public class Main {

    static boolean flag;
    static int n, k;
    static int[] number, selected;
    static boolean[] visited;
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws Exception{
        inputSetting();
        perm(0);
        bw.append(sb);
        bw.close();
    }
    static void findQArray(int[] arr){
        int size = n;

        while(0 < size){
            for(int i = 0; i < size - 1; i++){
                arr[i] = arr[i] + arr[i + 1];
            }
            size--;
        }
        if(arr[0] == k) {
            flag = true;
            for(int i = 0; i < n; i++) sb.append(selected[i]).append(" ");
        }
    }

    static void perm(int cnt){
        if(flag) return;

        if(cnt == n){
            findQArray(selected.clone());
            return;
        }

        for(int i = 0; i < n; i++){
            if(visited[i]) continue;

            visited[i] = true;
            selected[cnt] = number[i];
            perm(cnt + 1);
            visited[i] = false;
        }
    }

    static void inputSetting() throws Exception{
        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        number = new int[n];
        selected = new int[n];
        visited = new boolean[n];
        for(int i = 0; i < n; i++) number[i] = i + 1;
    }
}