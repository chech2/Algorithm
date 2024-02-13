import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
    static int n, minPrice;
    static int[] limit, selected, isPossible;
    static int[][] list;
    static ArrayList<String> selectStr = new ArrayList<>();
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        limit = new int[4];
        selected = new int[n];
        list = new int[n][5];
        isPossible = new int[4];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < 4; i++) {
            limit[i] = Integer.parseInt(st.nextToken());
        }
        String str = "";
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                list[i][j] = Integer.parseInt(st.nextToken());
                if(j == 4) minPrice += list[i][4];
                else isPossible[j] += list[i][j];
            }
            str += (i + 1 + " ");
        }

        for (int i = 0; i < 4; i++) {
            if(isPossible[i] < limit[i]){
                System.out.println(-1);
                System.exit(0);
            }
        }

        selectStr.add(str);
        set(0, 0, 0, 0, 0, 0, 0);
        Collections.sort(selectStr);

        bw.append(minPrice + "\n");
        bw.append(selectStr.get(0));
        bw.flush();
        bw.close();
    }
    public static void set(int selectCnt, int gidx,int price, int g1, int g2, int g3, int g4){
        if(limit[0] <= g1 && limit[1] <= g2 && limit[2] <= g3 && limit[3] <= g4 && price <= minPrice){
            String str = "";

            if(price < minPrice) selectStr.clear();
             for (int i = 0; i < selectCnt; i++) {
                str += ((selected[i] + 1) + " ");
             }
            selectStr.add(str);
            minPrice = price;
            return;
        }
        if(n <= gidx) return;


        //선택한 경우
        selected[selectCnt] = gidx;
        set(selectCnt + 1, gidx + 1, price + list[gidx][4], g1 + list[gidx][0], g2 + list[gidx][1], g3 + list[gidx][2], g4 + list[gidx][3]);

        //선택 안한 경우
        selected[selectCnt] = 16;
        set(selectCnt, gidx + 1, price, g1, g2, g3, g4);
    }
}