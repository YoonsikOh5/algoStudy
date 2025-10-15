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
        int N = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());

        while (!(N == 0 && D == 0)) {
            int[] arr = new int[N];
            for (int i = 0; i < D; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    int cur = Integer.parseInt(st.nextToken());
                    if (cur == 0) {
                        arr[j] = 1;
                    }
                }
            }

            boolean isT = false;
            for (int j = 0; j < N; j++) {
                if (arr[j] == 0) {
                    isT = true;
                    break;
                }
            }

            if (isT) {
                bw.write("yes\n");
            } else {
                bw.write("no\n");
            }

            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            D = Integer.parseInt(st.nextToken());
        }
        bw.flush();
        bw.close();
        br.close();
    }

}
