import java.io.*;
import java.math.BigInteger;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        for(int i = 0; i < N; i++){
            String a = br.readLine();
            String b = br.readLine();
            int len = b.length();
            boolean isT = true;
            for(int j = 0; j < len; j++){
                char c = b.charAt(j);
                String s = String.valueOf(c);
                if(!a.contains(s)){
                    isT = false;
                    break;
                }
            }
            if(isT){
                bw.write("YES\n");
            } else {
                bw.write("NO\n");
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }

}
