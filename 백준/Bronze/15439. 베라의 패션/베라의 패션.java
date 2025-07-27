import java.io.*;
public class Main {

    static int n, ans;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws Exception{
        n = Integer.parseInt(br.readLine());

        combi(0, 0);
        System.out.println(ans * 2);
    }

    static void combi(int cnt, int start){
        if(cnt == 2){
            ans++;
            return ;
        }

        for(int i = start; i < n; i++){
            combi(cnt + 1, i + 1);
        }
    }
}