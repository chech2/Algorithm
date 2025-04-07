import java.io.*;
import java.util.*;

public class Main {
    static List<Character> s, e;
    static int n;
    static char[] string;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws Exception{
        preSetting();
        System.out.println(addAlpha());
    }

    static int addAlpha(){
        for(int i = 0; i < n; i ++){
            if(isPalind(i)) return n + i;
        }
        return 2 * n;
    }

    static boolean isPalind(int s){
        int e = n - 1;
        while(s <= e){
            if(string[s++] != string[e--]) return false;
        }
        return true;
    }

    static void preSetting() throws Exception{
        string = br.readLine().toCharArray();
        n = string.length;

        s = new ArrayList<>();
        e = new ArrayList<>();
    }
}