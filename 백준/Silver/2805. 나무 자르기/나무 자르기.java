import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static int[] trees;
    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws Exception{
        pre_setting();
        bw.append(String.valueOf(binarySearch()));
        bw.close();
    }

    static int binarySearch(){
        int right,  left, h, ans;
        long cuttingH;

        right = 0;
        left = trees[n - 1];
        ans = left;

        while(right <= left){
            h = (right + left) / 2;
            cuttingH = cutting(h);

            if(cuttingH < m) left = h - 1;
            else{
                right = h + 1;
                ans = h;
            }
        }
        return ans;
    }


    static long cutting(int h){
        long ans = 0;

        for(int i = 0; i < n; i++) ans += Math.max(0, trees[i] - h);

        return ans;
    }


    static void pre_setting() throws Exception{
        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        trees = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) trees[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(trees);
    }

}