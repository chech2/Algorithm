import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    static int T, n, m;
    static int[] aSum, bSum;
    static long ans;
    static HashMap<Long, Long> aHashMap;
    static HashMap<Long, Long> bHashMap;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        n = Integer.parseInt(br.readLine());
        aSum = arrInput(n, new StringTokenizer(br.readLine()));

        m = Integer.parseInt(br.readLine());
        bSum = arrInput(m, new StringTokenizer(br.readLine()));

        aHashMap = findHashMap(aSum);
        bHashMap = findHashMap(bSum);

        for (Map.Entry<Long, Long> now: aHashMap.entrySet()) {
            if(bHashMap.containsKey(T - now.getKey())){
                ans += bHashMap.get(T - now.getKey()) * now.getValue();
            }
        }

        System.out.println(ans);
    }
    public static HashMap<Long, Long> findHashMap(int[] arr){
        HashMap<Long, Long> result = new HashMap<>();

        long key;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                key = arr[j] - arr[i];
                if(result.containsKey(key)){
                    result.put(key, result.get(key) + 1);
                }else result.put(key, 1L);
            }
        }
        return result;
    }

    public static int[] arrInput(int size, StringTokenizer st){
        int[] result = new int[size + 1];

        for (int i = 1; i < size + 1; i++) {
            result[i] = Integer.parseInt(st.nextToken()) + result[i - 1];
        }
        return result;
    }

}