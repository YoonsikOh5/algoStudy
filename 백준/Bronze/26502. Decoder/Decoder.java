import java.io.*;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDate;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        HashMap<Character, Character> hm = new HashMap<>();

        hm.put('y','a');
        hm.put('a','e');
        hm.put('e','i');
        hm.put('i','o');
        hm.put('o','u');
        hm.put('u','y');
        hm.put('Y','A');
        hm.put('A','E');
        hm.put('E','I');
        hm.put('I','O');
        hm.put('O','U');
        hm.put('U','Y');

        for(int i = 0; i < N; i++){
            String s = br.readLine();
            int len = s.length();
            for(int j = 0; j < len; j++){
                char cur = s.charAt(j);
                if(hm.containsKey(cur)){
                    Character character = hm.get(cur);
                    bw.write(character+"");
                } else {
                    bw.write(cur+"");
                }
            }
            bw.write("\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

}
