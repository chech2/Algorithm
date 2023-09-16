import java.util.*;
public class Main {
    static int N, cnt, start, end, sum, size;
    static boolean decimal[];
    static ArrayList<Integer> number = new ArrayList<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();

        decimal = new boolean[N + 1];
        Arrays.fill(decimal, true);

        decimal[0] = false;
        decimal[1] = false;

        //에라토스테네스의 체로 거르기
        for (int i = 2; i * i <= N; i++) {
            if(!decimal[i]) continue;
            for (int j = i * i; j <= N; j += i) {
                decimal[j] = false;
            }
        }

        for (int i = 2; i < N + 1; i++) {
            if(decimal[i]) number.add(i);
        }

        size = number.size();
        if(size == 0){
            System.out.println(0);
            System.exit(0);
        }

        //투 포인터 이용해서 체크하기
        sum = number.get(start);
        while(true){
            if(sum < N){
                end++;
                if(size <= end) break;
                sum += number.get(end);
            }else if(N < sum){
                sum -= number.get(start);
                start++;
            } else if (N == sum) {
                cnt++;
                sum -= number.get(start);
                start++;
            }
        }
        System.out.println(cnt);
    }
}