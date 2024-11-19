import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {
    static int n;
    static ArrayList<word> str;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws Exception {
        pre_setting();
        sort();

        for (int i = 0; i < n; i++) bw.append(str.get(i).str).append("\n");

        bw.close();
    }

    static void sort(){

        Collections.sort(str, (word o1, word o2) -> {


            int min_size = Math.min(o1.seperatedword.size(), o2.seperatedword.size());

            String o1_now, o2_now;
            boolean o1_is_num, o2_is_num;
            BigInteger o1_digi, o2_digi;
            for(int i = 0, j = 0; i < min_size; i++, j++) {
                o1_now = o1.seperatedword.get(i);
                o2_now = o2.seperatedword.get(j);

//                System.out.println("><" + o1.str + " " + o2.str + "  > " + o1_now + " " + o2_now);


                o1_is_num = Character.isDigit(o1_now.charAt(0));
                o2_is_num = Character.isDigit(o2_now.charAt(0));

                // 둘다 숫자인 경우
                 if(o1_is_num && o2_is_num) {
                    o1_digi = new BigInteger(o1_now);
                    o2_digi = new BigInteger(o2_now);

//                     System.out.println(" >  " + o1_digi + " " + o2_digi);
                    if(o1_digi.equals(o2_digi) && o1_now.length() != o2_now.length()) return o1_now.length() - o2_now.length();
                    else if(!o1_digi.equals(o2_digi)) return o1_digi.compareTo(o2_digi);
                 }

                // 숫자 + 문자
                else if(o1_is_num && !o2_is_num) return -1;
                else if(!o1_is_num && o2_is_num) return 1;


                // 둘다 문자인 경우
                else if(!o1_is_num && !o2_is_num) {
                    if(o1_now.equals(o2_now)) continue;
                    if(o1_now.equalsIgnoreCase(o2_now)) {
//                        System.out.println(o1.str + " " + o2.str + "  > " + o1_now + " " + o2_now);
                        if (o1_now.toUpperCase().compareTo(o1_now) == 0) {
                            return -1;
                        }
                        return 1;
                    }
                     return o1_now.compareToIgnoreCase(o2_now);
                }
            }
            return o1.str.length() - o2.str.length();

        });
    }

    static void pre_setting() throws Exception{
        n = Integer.parseInt(br.readLine());

        str = new ArrayList<>();
        for(int i = 0; i < n; i++) str.add(new word(br.readLine()));

    }

    static class word{
        String str;
        ArrayList<String> seperatedword;

        public word(String str){
            this.str = str;
            set_seperated_str(str);
        }

        void set_seperated_str(String str){
            seperatedword = new ArrayList<>();
            StringBuilder sb = new StringBuilder();

            char now;
            for(int i = 0; i < str.length(); i++){
                now = str.charAt(i);

                if(Character.isDigit(now)){
                    sb.append(now);
                    continue;
                }else if(0 < sb.length()){ // 이전에 있던 숫자를 분리리스트
                    seperatedword.add(sb.toString());
                    sb = new StringBuilder();
                }
                seperatedword.add(String.valueOf(now));
            }
            if (sb.length() > 0) { // 다 돌고 빌더에 남아 있는 것이 있으면 마저 넣어줌
                seperatedword.add(sb.toString());
            }
        }
    }
}