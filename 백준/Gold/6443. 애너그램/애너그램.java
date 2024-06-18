import java.io.*;
import java.util.*;
public class Main {
    static int n, size;
    static char[] words;
    static int[] visited;
    static TreeSet<String> set = new TreeSet<>();
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws Exception{
        n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            input();
            recur(0, "");
            print();
        }

        System.out.println(sb);
    }

    public static void print(){
        for (String now : set) sb.append(now).append("\n");

        set.clear();
    }

    public static void recur(int cnt, String str){
        if(cnt == size){
            set.add(str);
            return;
        }

        for (int i = 0; i < 26; i++) {
            if(visited[i] == 0) continue;
            visited[i]--;
            recur(cnt + 1, str + (char)(i + 'a'));
            visited[i]++;

        }
    }

    public static void input() throws Exception{
        words = br.readLine().toCharArray();
        size = words.length;
        visited = new int[26];

        for (int i = 0; i < size; i++) visited[words[i] - 'a']++;
    }
}