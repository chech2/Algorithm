import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, result;

    //입력되는 재료 배열
    static int[][] ingredients;
    static boolean[] visited;

    //최소 영양분 조건: 단, 지, 탄, 비
    static int[] nutrients = new int[4];
    static ArrayList <String> list = new ArrayList<>();

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        ingredients = new int[N][5];
        visited = new boolean[N];
        result = Integer.MAX_VALUE;

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            nutrients[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                ingredients[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        subset(0);

        if(result == Integer.MAX_VALUE) System.out.println(-1);
        else{
            //Todo 사전 순의 값이 출력되어야 함
            System.out.println(result);
            Collections.sort(list);
            System.out.println(list.get(0));

        }

    }

    public static void subset(int cnt){

        //부분집합 생성완료
        if(N == cnt){
            minimumPrice();
            return;
        }
        visited[cnt] = false;
        subset(cnt + 1);
        visited[cnt] = true;
        subset(cnt + 1);


    }

    //단지탄비
    public static void minimumPrice(){
        int protein = 0;
        int carbohydrate = 0;
        int fat = 0;
        int vitamin = 0;
        int price = 0;

        for (int i = 0; i < N; i++) {

            //현재 선택된 경우
            if(visited[i]){
                protein += ingredients[i][0];
                fat += ingredients[i][1];
                carbohydrate += ingredients[i][2];
                vitamin += ingredients[i][3];
                price += ingredients[i][4];

            }
        }
        if(protein >= nutrients[0] && fat >= nutrients[1] && carbohydrate >= nutrients[2] && vitamin >= nutrients[3])
            if(price < result) {
                result = price;
                list.clear();
                String str = "";
                for (int i = 0; i < N; i++) {
                    //현재 선택된 경우
                    if (visited[i]) {
                        str += (i + 1) + " ";
                    }
                }
                list.add(str);
            }
            else if(price == result){
                String str = "";
                for (int i = 0; i < N; i++) {
                    //현재 선택된 경우
                    if (visited[i]) {
                        str += (i + 1) + " ";
                    }
                }
                list.add(str);
            }
        }

    }