import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    //순서대로: 초항, 공차, 쿼리 개수, 시작 항, 끝 항, 명령어, 결과
    static long a, d, q, start, end, command;
    static long[] result = new long[2];
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        a = Long.parseLong(st.nextToken());
        d = Long.parseLong(st.nextToken());
        q = Long.parseLong(br.readLine());

        for (int i = 0; i < q; i++) {
            st = new StringTokenizer(br.readLine());
            command = Long.parseLong(st.nextToken());
            start = Long.parseLong(st.nextToken());
            end = Long.parseLong(st.nextToken());

            //end - start까지의 합 구하기
            if(command == 1){
                result[0] = 0;
                long n = end - start + 1;
                result[0] = (n * (cal(start) + cal(end))) / 2;
                System.out.println(result[0]);
            }
            else{
                if(start == end)
                    System.out.println(cal(start));
                else{
                    if(result[1] == 0) result[1] = gcd(a, d);
                    System.out.println(result[1]);
                }
            }
        }
    }

    static long cal(long num){
        return a + (num - 1) * d;
    }
    static long gcd(long a, long d){
        return d > 0 ? gcd(d, a % d) : a;
    }
}