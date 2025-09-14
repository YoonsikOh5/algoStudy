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
        long N = Long.parseLong(st.nextToken());
        long M = Long.parseLong(st.nextToken());
        long S = Long.parseLong(st.nextToken());
        long a = ((100-N) * (M+1) * S) / 100;
        long b = M * S;
        long res = Math.min(a, b);
        bw.write(res+"");
        bw.flush();
        bw.close();
        br.close();
    }

}
