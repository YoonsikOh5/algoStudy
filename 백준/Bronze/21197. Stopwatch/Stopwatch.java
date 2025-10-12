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

        int N = Integer.parseInt(br.readLine().trim());
        int bef = 0;
        int cnt = 0;
        boolean isR = false;
        for (int i = 0; i < N; i++) {
            int cur = Integer.parseInt(br.readLine().trim());
            if (isR) {
                isR = false;
                cnt += cur - bef;
                bef = cur;
            } else {
                isR = true;
                bef = cur;
            }
        }
        if (!isR) {
            bw.write(cnt + "");
        } else {
            bw.write("still running");
        }
        bw.flush();
        bw.close();
        br.close();
    }

}
