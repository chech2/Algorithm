import java.io.*;
import java.util.*;

public class Main {
    static int n, ans;
    static char s[];
    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws Exception{
        inputSetting();
        sizeCheck();
        System.out.println(ans);
    }

    static void sizeCheck(){
        Map<Character, Integer> alpha = new HashMap<>();
        int l, r, type;

        l = 0;
        r = 0;
        type = 0;

        while(r < s.length){
            if(alpha.getOrDefault(s[r], 0) == 0){
                type++;
                alpha.put(s[r], 1);

                while(n < type && l <= r) {
                    if (alpha.get(s[l]) == 1){
                        type--;
                        alpha.remove(s[l]);
                    }
                    else alpha.put(s[l], alpha.get(s[l]) - 1);

                    l++;
                }
            }
            else alpha.put(s[r], alpha.get(s[r]) + 1);

            ans = Math.max(ans, r - l + 1);
            r++;
        }
    }

    static void inputSetting() throws Exception{
        ans = 1;
        n = Integer.parseInt(br.readLine());
        s = br.readLine().toCharArray();
    }
}