import java.io.*;
import java.util.*;

class Main {
    static int ans;
    static int[] card_count;
    static ArrayList<Integer>[] cards;
    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws Exception{
        pre_setting();
        
        int a, b, c, c2;
        for(int i = 0; i < card_count[0]; i++){
            a = cards[0].get(i);
            b = binarySearch(a, 1);
            c = binarySearch(b, 2);
            c2 = binarySearch(a, 2);

            ans = Math.min(ans, Math.max(a, Math.max(b, c)) - Math.min(a, Math.min(b, c)));
            ans = Math.min(ans, Math.max(a, Math.max(b, c2)) - Math.min(a, Math.min(b, c2)));
        }
        bw.append(String.valueOf(ans));
        bw.close();
    }

    static int binarySearch(int select_number, int idx){
        int s, e, m, num, pre;
        s = 0;
        e = card_count[idx] - 1;
        pre = cards[idx].get((s + e) / 2);

        while(s <= e){
            m = (s + e) / 2;
            num = cards[idx].get(m);

            if(num == select_number) return num;
            else if(num < select_number) s = m + 1;
            else e = m - 1;

            if(Math.abs(num - select_number) < Math.abs(pre - select_number)) pre = num;

        }
        return pre;
    }

    static void pre_setting() throws Exception{
        ans = 200000001;
        st = new StringTokenizer(br.readLine());
        card_count = new int[3];
        cards = new ArrayList[3];

        for(int i = 0; i < 3; i++){
            card_count[i] =  Integer.parseInt(st.nextToken());
            cards[i] = new ArrayList<>();
        }

        for(int i = 0; i < 3; i++){
            st = new StringTokenizer(br.readLine());

            for(int j = 0; j < card_count[i]; j++) cards[i].add(Integer.parseInt(st.nextToken()));
            Collections.sort(cards[i]);

        }
    }
}