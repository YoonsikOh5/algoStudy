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

        for(int i = 0; i < T; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            long k = Long.parseLong(st.nextToken());
            long cur = Long.parseLong(st.nextToken());
            StringBuilder sb = new StringBuilder();
            while (cur > 0){
                long l = cur % 10;
                long lk = (l + k) % 10;
                sb.append(lk);
                cur /= 10;
            }
            StringBuilder rev = sb.reverse();
            bw.write(rev.toString()+"\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }

}
