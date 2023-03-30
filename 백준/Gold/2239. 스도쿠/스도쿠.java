import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {


    static int map[][] = new int[9][9];
    static int result[][] = new int[9][9];
    static int smallcheck = 10;
    static ArrayList<node> Zero = new ArrayList<>();

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for (int i = 0; i < 9; i++) {
            st = new StringTokenizer(br.readLine());
            char tmp[] = st.nextToken().toCharArray();

            for (int j = 0; j < 9; j++) {
                map[i][j] = tmp[j] - '0';
                if(map[i][j] == 0)
                    Zero.add(new node(i, j));
            }
        }
        dfs(0);
        print();
    }

    private static void dfs(int cnt){
        if(cnt == Zero.size()) {
            print();
            System.exit(0);
//            if(map[8][8] < smallcheck) {
//                smallcheck = map[8][8];
//                for (int i = 0; i < 9; i++) {
//                    result[i] = map[i].clone();
//                }
//            }
//            return;
        }

        node now = Zero.get(cnt);
        int x = now.x;
        int y = now.y;

        for (int i = 1; i <= 9; i++) {

            if(check(x, y, i)){
                map[x][y] = i;
                dfs(cnt + 1);
                map[x][y] = 0;
            }
        }
    }

    private static void print(){

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(map[i][j]);
            }
            System.out.println();
        }

    }


    //스도쿠 규칙 체크
    private static boolean check(int x, int y, int insert){

        for (int i = 0; i < 9; i++) {
            if(map[x][i] == insert) return false;
            if(map[i][y] == insert) return false;
        }

        int startX = x / 3 * 3;
        int startY = y / 3 * 3;

        for (int i = startX; i < startX + 3; i++) {
            for (int j = startY; j < startY + 3; j++) {
                if(map[i][j] == insert) return false;
            }
        }
        return true;
    }
    private static class node{
        int x;
        int y;

        node(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}