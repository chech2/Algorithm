import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N,L,R, day;
    static int [][] map, group;
    static int [] result, cnt;

    //상,하,좌,우
    static int [] dx = {-1,1,0,0};
    static int [] dy = {0,0,-1,1};
    static boolean [][] visited;
    static boolean isvalid, samegroup;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        map = new int[N][N];
        result = new int[N*N];
        cnt = new int[N*N];


        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] =  Integer.parseInt(st.nextToken());
            }
        }

        /////////////////// 입력값 세팅
        while(true) {
            int groupNum = 0;
            visited = new boolean[N][N];
            group = new int[N][N];
            for (int [] g : group) {
                Arrays.fill(g, -1);
            }
            //얘만 되면 안됨
//            group[0][0] = 0;
            Arrays.fill(result, 0);
            Arrays.fill(cnt, 0);
            isvalid = false;

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                	if(group[i][j] != -1) continue;
                	group[i][j] = groupNum;
                	samegroup = false;
                    dfs(i, j, groupNum++);
                    //같은 그룹이 없다면 
                    if(!samegroup) group[i][j] = -1;
                }
            }
            setting();
//            print();
//            System.out.println();
            if(!isvalid) break;
        }
        System.out.println(day);
    }

    private static void setting() {
        for (int i = 0; i <N; i++) {
            for (int j = 0; j < N; j++) {
                if(group[i][j] == -1) continue;
                result[group[i][j]] += map[i][j];
                cnt[group[i][j]]++;
            }
        }
        for (int i = 0; i <N; i++) {
            for (int j = 0; j < N; j++) {
                if(group[i][j] == -1) continue;
                int changeNum = result[group[i][j]] / cnt[group[i][j]];

                if(changeNum != map[i][j]) {
//                    System.out.println("!!!!!!!!"+changeNum +" "+ map[i][j] +" "+ i + " " + j);
                    isvalid = true;
                }
                map[i][j] = changeNum;

            }
        }
        if(isvalid) day++;
    }

    private static void dfs(int x, int y, int groupNum) {
        visited[x][y] = true;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (0 <= ny && ny < N && 0 <= nx && nx < N && !visited[nx][ny]) {
                int difference = Math.abs(map[x][y] - map[nx][ny]);
                if(L <= difference && difference <= R){
                    group[nx][ny] = groupNum;
                    samegroup = true;
                    dfs(nx, ny, groupNum);
                }
            }

        }
    }

    public static void print(){
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(group[i][j] + "  ");
            }
            System.out.println();
        }
    }
}