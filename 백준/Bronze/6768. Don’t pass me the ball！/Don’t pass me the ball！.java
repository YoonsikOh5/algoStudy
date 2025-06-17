import java.io.*;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDate;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long l = Long.parseLong(br.readLine());

        if (l > 3) {
            long res = 1;
            for (int i = 1; i < 4; i++) {
                res *= (l - i);
            }
            bw.write(res/6 + "");

        } else {
            bw.write("0");
        }

        bw.flush();
        bw.close();
        br.close();
    }

}
