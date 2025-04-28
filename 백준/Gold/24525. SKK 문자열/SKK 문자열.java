import java.io.*;
import java.util.*;

public class Main {
    static int ans;
    static Map<Integer, Integer> maxIdx, minIdx;
    static int[] s, prefix, kcnt, scnt;
    public static void main(String[] args) throws Exception{
        inputSetting();
        if(0 < scnt[s.length] && 1 < kcnt[s.length]) findSKK();
        
        System.out.println(ans);
    }

    static void findSKK() {
        int key;

        for(Map.Entry<Integer, Integer> minvalue : minIdx.entrySet()){
            key = minvalue.getKey();
            if(maxIdx.containsKey(key)){
                if(kcnt[maxIdx.get(key)] - kcnt[minvalue.getValue()] != 0 || scnt[maxIdx.get(key)] - scnt[minvalue.getValue()] != 0) ans = Math.max(ans, maxIdx.get(key) - minvalue.getValue());
            }
        }

        if(ans == 0) ans = -1;
    }

    static void inputSetting() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] inputString = br.readLine().toCharArray();
        s = new int[inputString.length];
        prefix = new int[s.length + 1];
        kcnt = new int[s.length + 1];
        scnt = new int[s.length + 1];

        maxIdx = new HashMap<>();
        minIdx = new HashMap<>();
        minIdx.put(0, 0);

        int now;
        for(int i = 0; i < s.length; i++){
            kcnt[i + 1] += kcnt[i];
            scnt[i + 1] += scnt[i];
            
            if(inputString[i] == 'S') {
                now = 2;
                scnt[i + 1]++;
            } else if(inputString[i] == 'K') {
                now = -1;
                kcnt[i + 1]++;
            } else {
                now = 0;
            }

            s[i] = now;
            prefix[i + 1] = prefix[i] + s[i];
            maxIdx.put(prefix[i + 1], i + 1);
            if(!minIdx.containsKey(prefix[i + 1])) minIdx.put(prefix[i + 1], i + 1);
        }

        ans = -1;
    }
}