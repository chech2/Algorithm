import java.io.*;
import java.util.*;

public class Main {

    static int n, ans;
    static int[] people;
    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws Exception{
        pre_setting();
        window();
        bw.append(String.valueOf(ans));
        bw.close();
    }

    static void window(){
        int s = 0;
        int e = n - 1;

        while(s + 1 < e){
            ans = Math.max(ans, (e - s - 1) * Math.min(people[s], people[e]));
            if(people[e] < people[s]) e--;
            else s++;
        }
    }
    static void pre_setting() throws Exception{
        n = Integer.parseInt(br.readLine());
        people = new int[n];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) people[i] = Integer.parseInt(st.nextToken());
    }

}