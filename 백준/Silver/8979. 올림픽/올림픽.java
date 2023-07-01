import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static int N, K;
    static int rank = 1;

    static PriorityQueue<country> list = new PriorityQueue<>(
            (o1, o2) -> {
                if(o1.gold != o2.gold){
                    return  o2.gold - o1.gold;
                }else if (o1.silver != o2.silver ) {
                    return  o2.silver - o1.silver;
                }else{
                    return o2.bronze - o1.bronze;
                }
            });
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader((new InputStreamReader(System.in)));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        int no, gold, silver, bronze;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            no = Integer.parseInt(st.nextToken());
            gold = Integer.parseInt(st.nextToken());
            silver = Integer.parseInt(st.nextToken());
            bronze = Integer.parseInt(st.nextToken());
            list.add(new country(no, gold, silver, bronze));
        }
        int same = 0;
        country pre = list.poll();
        if(pre.no == K){
            System.out.println(1);
            System.exit(0);
        }
        for (int i = 1; i < N; i++) {
            country now = list.poll();
            if (now.gold != pre.gold) {
                if (same != 0) {
                    rank += same;
                    same = 0;
                }
                rank++;
            } else if (now.silver != pre.silver) {
                if (same != 0) {
                    rank += same;
                    same = 0;
                }
                rank++;
            } else { //동메달
                if (now.bronze == pre.bronze) {
                    same++;
                } else {
                    if (same != 0) {
                        rank += same;
                        same = 0;
                    }
                    rank++;
                }
            }
            pre = now;
            if (now.no == K) {
                System.out.println(rank);
                break;
            }
        }
        

    }

    public static class country{
        int no, gold, silver, bronze;
        int status = 0;
        country(int no, int gold, int silver, int bronze){
            this.no = no;
            this.gold = gold;
            this.silver = silver;
            this.bronze = bronze;
        }
    }
}