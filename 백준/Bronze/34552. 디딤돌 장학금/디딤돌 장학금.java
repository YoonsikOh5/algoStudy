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

        int[] arr = new int[11];

        int res = 0;

        for (int i = 0; i < 11; i++) {
            int cur = Integer.parseInt(st.nextToken());
            arr[i] = cur;
        }
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            double b = Double.parseDouble(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            if (b >= 2.0 && c >= 17) {
                res += arr[a];
            }
        }
        bw.write(res + "");
        bw.flush();
        bw.close();
        br.close();
    }

}
