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
        boolean isT = true;
        for (int i = 0; i < N; i++) {
            int cur = Integer.parseInt(br.readLine());
            if (cur < 48) {
                isT = false;
            }
        }
        if (isT) {
            bw.write("True");
        } else {
            bw.write("False");
        }
        bw.flush();
        bw.close();
        br.close();
    }

}
