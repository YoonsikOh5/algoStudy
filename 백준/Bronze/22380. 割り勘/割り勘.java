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

        while (true) {

            StringTokenizer st = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            if(n == 0 && m == 0){
                break;
            }
            st = new StringTokenizer(br.readLine());

            int res = 0;
            int tgt = m / n;
            for (int i = 0; i < n; i++) {
                int cur = Integer.parseInt(st.nextToken());
                int min = Math.min(tgt, cur);
                res += min;
            }
            bw.write(res + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }

}
