import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    static int n, k, start, end, ans;
    static int[] score;
    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws Exception{
        input();
        binarySearch();
        System.out.println(ans);
    }

    public static void binarySearch(){
        int mid, issep;
        while(start <= end){
            mid = (start + end) / 2;

            issep = isseparation(mid);
            if(issep <= 0){
                start = mid + 1;
                if(issep == 0) ans = mid;
            }else{
                end = mid - 1;
            }
        }
    }

    public static int isseparation(int num){
        int sum = 0;
        int group = 1;

        for (int i = 0; i < n; i++) {
            if(sum < num){
                sum += score[i];
            }else{
                group++;
                sum = score[i];
            }
        }
        if(sum < num) group--;
        if(k < group) return -1;
        else if(k == group) return 0;
        return 1;
    }

    public static void strToken() throws Exception{
        st = new StringTokenizer(br.readLine());
    }

    public static void input() throws Exception{
        strToken();
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        score = new int[n];
        strToken();
        for (int i = 0; i < n; i++) {
            score[i] = Integer.parseInt(st.nextToken());
            end += score[i];
        }
    }
}