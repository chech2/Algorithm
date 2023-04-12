import java.util.HashSet;

public class Main {

    static HashSet<Integer> NonSelfNum = new HashSet<>();
    static final int end = 10000;

    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < end; i++) {
            d(i);
        }
        for (int i = 1; i < end; i++) {
            if(!NonSelfNum.contains(i))
                sb.append(i).append("\n");
        }
        System.out.println(sb);
    }
    static void d(int n){
        //1000이상은 볼 필요 없음
        if(n > end) return;

        //재귀 시작
        int result = 0;
        int dist = n < 10 ? 1 : n < 100 ? 2 : n < 1000 ? 3 : 4;
        result += n;
        for (int i = 0; i < dist; i++) {
            result += n % 10;
            n /= 10;
        }
        if(!NonSelfNum.contains(result)){
            NonSelfNum.add(result);
            d(result);
        }
    }
}