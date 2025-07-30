import java.io.*;
import java.util.*;

public class Main {
    static int[] selected;
    static boolean[][] map;
    static List<p> rectangle;
    static int n, ans;
    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws Exception{
        inputSetting();
        combi(0, 0);
        System.out.println(ans);
    }

    static void combi(int cnt, int start){
        if(cnt == 2){
            ans = Math.max(ans, rectangleSize(rectangle.get(selected[0]), rectangle.get(selected[1])));
            return;
        }

        for(int i = start; i < rectangle.size(); i++){
            selected[cnt] = i;
            combi(cnt + 1, i + 1);
        }
    }

    static int rectangleSize(p one, p two){
        int minX, minY, maxX, maxY, result;

        minX = Math.min(one.x, two.x);
        maxX = Math.max(one.x, two.x);
        minY = Math.min(one.y, two.y);
        maxY = Math.max(one.y, two.y);
        if((maxX - minX) * (maxY - minY) <= ans) return 0;

        for(int i = minX; i < maxX; i++){
            for(int j = minY; j < maxY; j++){
                if(map[i][j]) return 0;
            }
        }
        return (maxX - minX) * (maxY - minY);
    }

    static void inputSetting() throws Exception{
        map = new boolean[101][101];
        selected = new int[2];

        n = Integer.parseInt(br.readLine());
        for (int i = 0; i < 101; i++) Arrays.fill(map[i], true);

        rectangle = new ArrayList<>();

        int x, y, nx, ny;
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());

            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());
            nx = x + 10;
            ny = y + 10;

            for(int dx = x; dx <= nx; dx++){
                for(int dy = y; dy <= ny; dy++){
                    rectangle.add(new p(dx, dy));
                    if(dx != nx && dy != ny) map[dx][dy] = false;
                }
            }
        }
    }

    static class p{
        int x, y;

        p(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}