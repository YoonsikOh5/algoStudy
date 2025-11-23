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
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n2 = 2 * N;
        int[] arr = new int[n2];
        for (int i = 0; i < n2; i++) {
            int cur = Integer.parseInt(st.nextToken());
            arr[i] = cur;
        }
        int max = 0;
        for (int i = 1; i <= N; i++) {
            int bef = -1;
            int aft = -1;
            for (int j = 0; j < n2; j++) {
                int cur = arr[j];
                if (cur == i && bef == -1) {
                    bef = j;
                } else if (cur == i && bef != -1) {
                    aft = j;
                    int dif = aft - bef - 1;
                    max = Math.max(dif, max);
                }
            }
        }

        bw.write(max + "");
        bw.flush();
        bw.close();
        br.close();
    }

}
