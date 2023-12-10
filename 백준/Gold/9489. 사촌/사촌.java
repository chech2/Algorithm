import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.stream.Stream;

public class Main {
    static int N, K, Kidx;
    static int[] input, groupCnt, group, level;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        while(true){
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            Kidx = 0;
            //종료 조건
            if(N == 0 && K == 0) {
                break;
            }

            // 입력 배열
            input = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            group = new int[input.length];
            groupCnt = new int[input.length];
            level = new int[input.length];

            int cnt = 1;
            groupCnt[0] = cnt;
            for (int i = 1; i < input.length; i++) {
                int now = input[i];
                if(now == K){
                    Kidx = i;
                }

                //연속된 배열인 경우 => 같은 그룹
                if(input[i - 1] + 1 == now){
                    group[i] = group[i - 1];
                    cnt++;
                }
                //연속된 배열이 아닌 경우
                else{
                    group[i] = group[i - 1] + 1;
                    groupCnt[group[i - 1]] = cnt;

                    cnt = 1;
                }
                if(i == input.length - 1){
                    groupCnt[group[i]] = cnt;
                }
            }
            level[0] = 0;

            int groupIdx = 1;
            int groupNumber = 0;
            int levelValue = 1;
            int groupSize = group.length;
            for (int groupCntNum: groupCnt) {
                groupNumber += groupCntNum;

                int j = 0;
                if(groupSize <= groupIdx) break;
                while(group[j + groupIdx] <= groupNumber){
                    level[j + groupIdx] = levelValue;
                    j++;
                    if(groupSize <= (j + groupIdx)) break;
                }
                levelValue++;
                groupIdx += j;
            }
            int KLevel = level[Kidx];
            int sameLevel = 0;
            for (int i = 0; i < level.length; i++) {
                if(KLevel == level[i]) sameLevel++;
            }
            System.out.println((sameLevel - groupCnt[group[Kidx]]));
        }
    }
}