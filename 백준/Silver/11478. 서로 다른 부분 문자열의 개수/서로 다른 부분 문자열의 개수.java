import java.io.*;
import java.util.*;

public class Main {
    static int n, answer;
    static char[] strs;
    static Set<String> set = new HashSet<>();
    static BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
    public static void main(String[] args) throws Exception{
        strs = br.readLine().toCharArray();
        n = strs.length;
        
        for(int i = 1; i < n; i++){
            answer += recur(i);
        }

        System.out.println(answer + 1);
    }

    static int recur(int size){
       int s = 0;
       int e = 0;
       int ans = 0;

        StringBuffer str = new StringBuffer();
        for(e = 0; e < size; e++){
           str.append(strs[e]);
        }
        
        if(!set.contains(str.toString())){
           set.add(str.toString());
           ans++;
        }

       for(; e < n; e++){
           str.deleteCharAt(0);
           str.append(strs[e]);
           
           if(!set.contains(str.toString())){
               set.add(str.toString());
               ans++;
           }
       }
       return ans;
    }
}
