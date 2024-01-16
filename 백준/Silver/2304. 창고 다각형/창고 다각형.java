import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {

    static int n, maxHigh, maxIdx, result;
    static node[] map;

    public static class node{
        int high, width;

        node(int high, int width){
            this.high = high;
            this.width = width;
        }
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());

        map = new node[n];
        int high, width;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            width = Integer.parseInt(st.nextToken());
            high = Integer.parseInt(st.nextToken());

            maxHigh = Math.max(maxHigh, high);
            map[i] = new node(high, width);
        }

        Arrays.sort(map, new Comparator<node>() {
            @Override
            public int compare(node o1, node o2) {
                return o1.width - o2.width;
            }
        });

        // 제일 큰 값을 기준으로 왼쪽 창고에 넣기
        int preIdx = 0;
        for (int i = 1; i < n; i++) {

            // 제일 큰 값을 기준으로 왼쪽의 창고 넓이
            if(map[preIdx].high <= map[i].high){
                result += (map[i].width - map[preIdx].width) * map[preIdx].high;
                preIdx = i;
            }
            if(map[i].high == maxHigh) {
                maxIdx = i;
                break;
            }
        }
        result += maxHigh;
        
        //제일 큰 값을 기준으로 오른쪽 창고에 넣기
        preIdx = n - 1;
        for (int i = n - 1; maxIdx <= i; i--) {
            // 제일 큰 값을 기준으로 오른쪽의 창고 넓이
            if(map[preIdx].high <= map[i].high){
                result += (map[preIdx].width - map[i].width) * map[preIdx].high;
                preIdx = i;
            }

        }
        System.out.println(result);

    }

}