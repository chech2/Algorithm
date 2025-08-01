import java.io.*;
import java.util.*;

public class Main {

    static List<Integer> num;
    static int B, C, SIZE;
    static boolean[] visited;
    static int[] selecteds;
    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws Exception{
        inputSetting();
        perm(0, 0);
        System.out.println(C);
    }

    static void perm(int cnt, int select){
        if(cnt == SIZE){
            if(B <= select || SIZE != (int) Math.log10(select) + 1) return;
            C = Math.max(C, select);
            return;
        }

        for(int i = 0; i < SIZE; i++){
            if(visited[i]) continue;

            visited[i] = true;
            select = select * 10 + num.get(i);
            perm(cnt + 1, select);
            select = (select - num.get(i)) / 10;
            visited[i] = false;
        }
    }

    static void inputSetting() throws Exception{
        st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        C = -1;

        num = new ArrayList<>();
        while(0 < a){
            num.add(a % 10);
            a /= 10;
        }
        SIZE = num.size();
        visited = new boolean[SIZE];
    }
}