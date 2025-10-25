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

        while (st.hasMoreTokens()) {
            int n = Integer.parseInt(st.nextToken());
            int bn = ((n - 1) * 2) - 1;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < i; j++) {
                    bw.write(" ");
                }
                if (i != n - 1) {
                    bw.write("*");
                }
                int bnm = bn - (i * 2);
                if (bnm <= 0) {
                    bnm = 0;
                }
                for (int j = 0; j < bnm; j++) {
                    bw.write(" ");
                }
                bw.write("*\n");
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }

}
