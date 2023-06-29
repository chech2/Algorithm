import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.StringTokenizer;


public class Main {
        static int N, fishNum, result;
        static int map[][], distance[][];
        static boolean visited[][];

        //x, y, 크기, 상어와의 거리
        //상어의 현 위치에서 BFS진행 (각 배열과의 거리를 모두 구하기)
        //단 상어가 지나 갈 수 있는 곳만

        //크기가 작으면 ok!

        //물고기 별 x좌표, y좌표, 크기, 고기 번호 저장
        static ArrayList<int []> fish = new ArrayList<>();
        //상어의 x, y, 크기 , 먹은 물고기의 개수
        static int[] Baby = new int [4];


        //상하좌우
        static int dx[] = new int[] {-1, 1, 0, 0};
        static int dy[] = new int[] {0, 0, -1, 1};

        public static void main(String[] args) throws Exception {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st;
            N = Integer.parseInt(br.readLine());
            map = new int[N][N];
            //아기 상어의 초기 크기
            Baby[2] = 2;

            //아기 상어가 잡아 먹은 물고기의 초기 값
            Baby[3] = 0;

//		visited = new boolean[N][N];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    int nowIn = Integer.parseInt(st.nextToken());
                    if (nowIn == 9) {
                        for (int k = 0; k < 4; k++) {
                            Baby[0] = i;
                            Baby[1] = j;
                        }
                        map[i][j] = 0;
                    } else if (nowIn != 0) {
                        fish.add(new int[]{i, j, nowIn, ++fishNum});
                        map[i][j] = nowIn;
                    }
                }
            }
            fish.sort(new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    return o1[2] - o2[2];
                }
            });
            ///////////////////////////////////입력값 세팅 완료/////////////////////////////////////////

            while(fishNum > 0 && fish.get(0)[2] < Baby[2]) {
                DistanceSet();
                if(!kill()) break;
            }
            System.out.println(result);
        }

        //물고기와 상어와의 거리가 동일한 경우 순서 조정 필요
        private static boolean kill() {
            int killNum = -1;
            int killPosion[] = new int[2];
            int killdistance = Integer.MAX_VALUE;
            for (int i = 0; i < fishNum; i ++){
                int tmpFish[] = fish.get(i);
                int x = tmpFish[0];
                int y = tmpFish[1];
                int size = tmpFish[2];
                //아기 상어보다 큰 물고기의 경우
                //정렬되어있으므로 더이상 볼 필요 없음
                if(size >= Baby[2]) break;
                if(distance[x][y] > 0) {
                    if (distance[x][y] < killdistance) {
                        killdistance = distance[x][y];
                        killPosion[0] = x;
                        killPosion[1] = y;
                        killNum = i;
                    } else if (distance[x][y] == killdistance) {
                        int existX = killPosion[0];
                        int existY = killPosion[1];
                        //상어와 물고기 간의 거리가 같은 경우

                        //1. 가장 위에 있는 물고기를 잡는다.
                        //2. 가장 왼쪽의 물고기를 잡는다.

                        //기존보다 아래 행에 존재
                        if (x > existX) continue;

                            //같은 행에 존재
                        else if (x == existX) {

                            //기존보다 더 왼쪽에 존재
                            if (y < existY) {
                                killPosion[0] = x;
                                killPosion[1] = y;
                                killNum = i;
                            }
                            //기존보다 더 오른 쪽에 존재
                            else
                                continue;
                        }

                        //기존보다 더 위에 존재
                        else {
                            killPosion[0] = x;
                            killPosion[1] = y;
                            killNum = i;
                        }
                    }
                }
            }
            if(killdistance != Integer.MAX_VALUE) {
//            System.out.println("죽일 수 있는 물고기는 다음과 같습니다.\n"+ fish.get(killNum)[3]+ "번째 물고기 => 크기: " + fish.get(killNum)[2]+" 좌표: " + killPosion[0] + " " + killPosion[1]);
//            System.out.println("죽일 수 있는 물고기는 다음과 같습니다.\n"+ fish.get(killNum)[3]+ "번째 물고기 => 크기: " + fish.get(killNum)[2]+" 좌표: " + fish.get(killNum)[0] + " " + fish.get(killNum)[1]);

//            System.out.println(Baby[0] + " " + Baby[1]);
                moveBaby(killPosion);
//            System.out.println(Baby[0] + " " + Baby[1]);
                map[Baby[0]][Baby[1]] = 0;
                fishNum--;
                fish.remove(killNum);
                result += killdistance;
                return true;
            }
//        System.out.println(killdistance);
            return false;
        }

        private static void moveBaby(int[] killPosion) {
            Baby[0] = killPosion[0];
            Baby[1] = killPosion[1];
            Baby[3]++;
            int Babysize = Baby[2];
            int eatting = Baby[3];
            if(Babysize == eatting) {
                Baby[2]++;
                Baby[3] = 0;
            }
        }

        ///////////////////////////////// 초기 세팅완료//////////////////////////////////////////////

    //BFS로 각 배열까지의 모든 거리 구하기 ()
    private static void DistanceSet() {
        ArrayDeque<int []> q = new ArrayDeque<>();
        visited = new boolean[N][N];
        distance = new int[N][N];

        //상어의 x, y, 크기 , 먹은 물고기의 개수

        q.add(new int[] {Baby[0], Baby[1], 0});
        visited[Baby[0]][Baby[1]] = true;

        while(!q.isEmpty()){
            int nowPosition[] = q.poll();
            int x = nowPosition[0];
            int y = nowPosition[1];
            int D = nowPosition[2];

            for (int i = 0; i < 4; i++) {
                int idxX = dx[i];
                int idxY = dy[i];
                int nx = idxX + x;
                int ny = idxY + y;
                //배열 범위 내부인 경우
                if(0 <= nx && nx < N && 0 <= ny && ny < N) {
                    //아기 상어가 지나갈 수 있는 경우
                    if(!visited[nx][ny] && map[nx][ny] <= Baby[2]) {
                        visited[nx][ny] = true;
                        distance[nx][ny] = D + 1;
                        q.add(new int[]{nx, ny, D + 1});
                    }
                }
            }
        }
    }
}