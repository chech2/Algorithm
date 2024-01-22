import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {
    static int n, primeCnt;
    static int[] primeList;
    static boolean[] isPrime;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        isPrime = new boolean[n + 1];
        primeList = new int[n + 1];
        Arrays.fill(isPrime, true);
        Arrays.fill(primeList, -1);
        findPrime();

        bw.append(primeSum() + "\n");
        bw.flush();
        bw.close();
    }

    public static void findPrime(){
        isPrime[0] = false;
        isPrime[1] = false;

        for(int i = 2; i <= n / i; i++){
            if(!isPrime[i]) continue;
            for (int j = i * 2; j <= n; j += i) {
                isPrime[j] = false;
            }
        }

        for (int i = 2; i < n + 1; i++) {
            if(isPrime[i]) {
                primeList[primeCnt] = i;
                primeCnt++;
            }
        }
    }

    public static int primeSum(){
        int start = 0, end = 0, ans = 0;
        int tmp = primeList[start];

        while(end < primeCnt){
            if(n <= tmp){
                if(tmp == n) ans++;
                tmp -= primeList[start++];
            }else if(tmp < n){
                tmp += primeList[++end];
            }
        }
        return ans;
    }
}