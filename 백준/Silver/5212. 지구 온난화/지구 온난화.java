import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int dx[] = {-1,1,0,0};
        int dy[] = {0,0,-1,1};
        char map[][] = new char [R][C];
        for (int i = 0; i < R; i++) {
            map[i] = br.readLine().toCharArray();
        }

        int Next50X[] = {-1,-1,-1,-1};
        int Next50Y[] = {-1,-1,-1,-1};
        for (int i = 0; i < R; i++){
            for(int j = 0; j < C; j++){
                if(map[i][j] != 'X') continue;
                int tmp = 0;
                for (int k = 0; k < 4; k++) {
                    if (0 <= i + dx[k] && i + dx[k] < R
                            && 0 <= j + dy[k] && j + dy[k] < C
                        && map[i + dx[k]][j + dy[k]] == '.')
                        tmp++;

                    else if(0 > i + dx[k] || i + dx[k] >= R || 0 > j + dy[k] || j + dy[k] >= C)
                        tmp++;
                }

                if(tmp >= 3) map[i][j] = 'F';
                if(map[i][j] == 'X' && Next50X[0] == -1 && tmp < 3) {
                    Next50X[0] = i;
                    Next50Y[0] = j;
                    Next50X[1] = i;
                    Next50Y[1] = j;
                }
                else if(map[i][j] == 'X' && tmp < 3) {
                    Next50X[1] = i;
                    if(j < Next50Y[0]){
                        Next50Y[0] = j;
                    }else if(Next50Y[1] < j){
                        Next50Y[1] = j;
                    }
                }
            }
        }

        for (int i = Next50X[0]; i <= Next50X[1]; i++){
            for(int j = Next50Y[0]; j <= Next50Y[1]; j++) {
                if(map[i][j] == 'F') map[i][j] = '.';
                sb.append(map[i][j]);
            }
//            System.out.println(i);
            if(i != Next50X[1]) sb.append("\n");
        }
        System.out.println(sb);
    }
}