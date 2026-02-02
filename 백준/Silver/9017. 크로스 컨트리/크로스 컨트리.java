import java.io.*;
import java.util.*;

public class Main {

    static int T, n;
    static int[] arr;
    static Map<Integer, Integer> teams;
    static Map<Integer, Team> gameInfo;
    static StringTokenizer st;
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception {
        T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            preSetting();
            teams = findCount();
            gameInfo = calTeamScore();

            ArrayList<Map.Entry<Integer, Team>> list =  new ArrayList<>(gameInfo.entrySet());

            list.sort((e1, e2) ->{
                Team o1 = e1.getValue();
                Team o2 = e2.getValue();

                if(o1.score == o2.score){
                    return o1.fiveScore - o2.fiveScore;
                }
                return o1.score - o2.score;
            });

            bw.append(String.valueOf(list.get(0).getKey())).append("\n");
        }
        bw.close();
    }

    static  Map<Integer, Team> calTeamScore(){
        Map<Integer, Team> answer = new HashMap<>();

        int s = 0;
        int team;
        Team info;
        for(int i = 0; i < n ; i++){
            if(!teams.containsKey(arr[i])) continue;
            s++;

            team = arr[i];
            if(answer.containsKey(team)){
                info = answer.get(team);

                if(info.cnt < 4) info.score += s;
                info.cnt++;

                if(info.cnt == 5) info.fiveScore = s;

                answer.put(team, info);
            } else{
                answer.put(team, new Team(s));
            }
        }

        return answer;
    }

    static Map<Integer, Integer> findCount(){
        Map<Integer, Integer> answer = new HashMap<>();

        int count;
        for(int i = 0; i < n ; i++){
            if(answer.containsKey(arr[i])){
                count = answer.get(arr[i]);

                answer.put(arr[i], count + 1);
            } else answer.put(arr[i], 1);
        }

        answer.values().removeIf(cnt -> cnt < 6);

        return answer;
    }

    static void preSetting() throws Exception{
        n = Integer.parseInt(br.readLine());
        arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n ; i++) arr[i] = Integer.parseInt(st.nextToken());
    }

    static class Team {
        int fiveScore, score, cnt;
        Team(int score){
            this.score = score;
            this.cnt = 1;
        }
    }
}
