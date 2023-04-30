import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;

public class Main {

    static int[][] Gear;
    static int[] record;
    static boolean[] visit;
    static int K, ans;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Gear = new int[4][8];

        ////////기어 입력//////////
        for (int i = 0; i < 4; i++) {
            String[] tmp = br.readLine().split("");

            for (int j = 0; j < 8; j++) {
                Gear[i][j] = Integer.parseInt(tmp[j]);
            }
        }

        /////////회전 횟수/////////
        K = Integer.parseInt(br.readLine());
        for (int i = 0; i < K; i++) {
            String[] tmp = br.readLine().split(" ");

            visit = new boolean[4];
            record = new int[4];
            Arrays.fill(record, 2);

            int curNUM = Integer.parseInt(tmp[0]) - 1;
            int curDIR = Integer.parseInt(tmp[1]);
            record[curNUM] = curDIR;

            //info에 맞춰서 회전하기
            if(curNUM == 0){
                for (int j = 1; j < 4; j++) {  //1번부터 회전하는지 확인
                    if(Gear[j - 1][2] != Gear[j][6]){ //회전할 수 있는 경우
                        record[j] = record[j - 1] * (-1);
                    }else break;
                }
            }else if (curNUM == 3){
                for (int j = 2; 0 <= j; j--) {  //1번부터 회전하는지 확인
                    if(Gear[j][2] != Gear[j + 1][6]){ //회전할 수 있는 경우
                        record[j] = record[j + 1] * (-1);
                    }else break;
                }
            }else if(curNUM == 1){
                if(Gear[0][2] != Gear[1][6]) record[0] = record[1] * (-1);
                if(Gear[1][2] != Gear[2][6]) record[2] = record[1] * (-1);
                if(record[2] != 2 && Gear[2][2] != Gear[3][6]) record[3] = record[2] * (-1);

            }else if(curNUM == 2){
                if(Gear[1][2] != Gear[2][6]) record[1] = record[2] * (-1);
                if(Gear[2][2] != Gear[3][6]) record[3] = record[2] * (-1);
                if(record[1] != 2 && Gear[0][2] != Gear[1][6]) record[0] = record[1] * (-1);

            }
            for (int j = 0; j < 4; j++) {
                if(record[j] == 2) continue;
                else if (record[j] == 1) {
                    Gear[j] = wise(Gear[j]);
                } else if (record[j] == -1) {
                    Gear[j] = counterwise(Gear[j]);
                }
            }
        }
        for (int j = 0; j < 4; j++) {
            if(Gear[j][0] == 1){
                if(j == 0) ans += 1;
                else if(j == 1) ans += 2;
                else if (j == 2) ans += 4;
                else ans += 8;
            }
        }
        System.out.println(ans);
    }

    //시계방향 회전
    static int[] wise(int [] origin){
        int [] tmp = new int[8];
        ArrayDeque<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < 7; i++) q.add(origin[i]);
        q.offerFirst(origin[7]);

        for (int i = 0; i < 8; i++) tmp[i] = q.poll();

        return tmp;
    }

    //반시계방향 회전
    static int[] counterwise(int [] origin){
        int [] tmp = new int[8];
        ArrayDeque<Integer> q = new ArrayDeque<>();
        for (int i = 1; i < 8; i++) q.offer(origin[i]);
        q.add(origin[0]);
        
        for (int i = 0; i < 8; i++) tmp[i] = q.poll();
        
        return tmp;
    }
}