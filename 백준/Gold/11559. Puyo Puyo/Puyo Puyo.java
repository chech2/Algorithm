import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

public class Main {
    static int result;
    static char[][] map = new char[12][6];
    static boolean[][] visited;
    //상하좌우
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static ArrayList<point> list;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 12; i++) {
            map[i] = br.readLine().toCharArray();
        }
        while(true) {
            boolean check = true;

            for (int i = 11; 0 <= i; i--) {
                for (int j = 0; j < 6; j++) {
                    if (map[i][j] != '.') {
                        visited = new boolean[12][6];
                        list = new ArrayList<point>();
                        //푸요의 폭파조건 확인
                        bfs(i, j);
                        //푸요 폭파 && 푸요 아래로 이동
                        if (list.size() >= 4) {
                            check = false;
                            boom();
                        }
                    }
                }
            }
            if(check) break;
            result++;
            waterfall();

        }
        System.out.println(result);

    }

    public static void boom() {
        int size = list.size();

        for (int i = 0; i < size; i++) {
            point now = list.get(i);
            int x = now.x;
            int y = now.y;
            map[x][y] = '.';
        }
    }
    public static void waterfall(){
        for (int i = 0; i < 6; i++) {
            for (int j = 11; 0 <= j ; j--) {
                if(map[j][i] == '.'){
                    for (int k = j; 0 <= k; k--) {
                        if(map[k][i] != '.'){
                            map[j][i] = map[k][i];
                            map[k][i] = '.';
                            break;
                        }
                    }
                }
            }
        }
    }

    public static void bfs(int r, int c){
        Queue<point> queue = new ArrayDeque<>();
        char nowCharactor = map[r][c];

        visited[r][c] = true;
        queue.add(new point(r, c));
        list.add(new point(r, c));

        while(!queue.isEmpty()){
            point now = queue.poll();

            for (int i = 0; i < 4; i++) {
                int x = now.x + dx[i];
                int y = now.y + dy[i];

                if(0 > x || x > 11 || 0 > y || y > 5) continue;
                if(visited[x][y]) continue;
                if(map[x][y] == nowCharactor){
                    visited[x][y] = true;
                    list.add(new point(x, y));
                    queue.add(new point(x, y));
                }
            }
        }
    }
 
    public static class point{
        int x, y;
        point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

}