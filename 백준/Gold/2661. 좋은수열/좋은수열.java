import java.io.*;
import java.util.*;
public class Main {
    static int n;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    public static void main(String[] args) throws Exception{
        n = Integer.parseInt(br.readLine());

        recur(1, 1, "1");
    }

    public static void recur(int cnt, int pre, String str){
        if(cnt == n){
            System.out.println(str);
            System.exit(0);
            return;
        }

        for (int i = 1; i < 4; i++) {
            if(pre != i && isGoodArr(str + i)) recur(cnt + 1, i, str + i);
        }
    }

    public static boolean isGoodArr(String str){
        int size = str.length() / 2;
        while(1 < size){
            for (int i = size; i + size < str.length() + 1; i++) {
                if(str.substring(i, i + size).equals(str.substring(i - size, i))) return false;
            }
            size--;
        }
        return true;
    }


}