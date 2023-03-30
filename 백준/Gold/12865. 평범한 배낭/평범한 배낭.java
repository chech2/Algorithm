import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int MaxWeight, ItemNum, MaxValue;
    static int memo[][];

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        ItemNum = Integer.parseInt(st.nextToken());
        MaxWeight = Integer.parseInt(st.nextToken());

        MaxValue = Integer.MIN_VALUE;
        memo = new int[ItemNum + 1][MaxWeight + 1];

        int W = 0;
        int V = 0;

        for (int i = 1; i < ItemNum + 1; i++) {
            st = new StringTokenizer(br.readLine());
            //무게
            W =  Integer.parseInt(st.nextToken());
            //가치
            V =  Integer.parseInt(st.nextToken());
            for (int j = 1; j < MaxWeight + 1; j++) {
                //현재 물건이 무거워서 담지 못하는 경우
                if(W > j){
                    memo[i][j] = memo[i - 1][j];
                }else{
                    memo[i][j] = Math.max(memo[i - 1][j - W] + V, memo[i - 1][j]);
                }
            }
        }
        System.out.println(memo[ItemNum][MaxWeight]);
    }


}