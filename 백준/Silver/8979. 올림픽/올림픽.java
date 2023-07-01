import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static int N, K;
    static int rank = 0;
    static PriorityQueue<country> list = new PriorityQueue<>(
            (o1, o2) -> {
                if(o1.gold != o2.gold){
                    return  o2.gold - o1.gold;
                }else if (o1.silver != o2.silver ) {
                    return  o2.silver - o1.silver;
                }else{
                    if(o2.bronze == o1.bronze)  {
                        o2.status = 1;
                        o1.status = 1;
                    }
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
        for (int i = 0; i < N; i++) {
            country test = list.poll();
            if(test.status == 1){
                if(same == 0) rank++;
                same++;
            }
            else if(test.status == 0 && same != 0){
                rank += same;
                same = 0;
            } else if (test.status == 0 && same == 0) rank++;
            if(test.no == K){
                System.out.println(rank);
                System.exit(0);
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