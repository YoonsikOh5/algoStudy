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
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        int rcnt = 0;
        int ccnt = 0;

        for (int i = 1; i <= a; i++) {
            rcnt++;
            i += c;
        }
        for (int i = 1; i <= b; i++) {
            ccnt++;
            i += d;
        }

        int res = rcnt*ccnt;

        bw.write(res+"");
        bw.flush();
        bw.close();
        br.close();
    }

}
