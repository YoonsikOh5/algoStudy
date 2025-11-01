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

        int T = Integer.parseInt(br.readLine());

        for(int i = 1; i <= T; i++){
            String s = br.readLine();
            String sub1 = s.substring(0, 2);
            String sub2 = s.substring(2, 4);
            int ab = Integer.parseInt(sub1);
            int cd = Integer.parseInt(sub2);
            int mod = (ab * ab + cd * cd) % 7;
            if(mod == 1){
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
