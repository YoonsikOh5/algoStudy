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

        long[] arr = new long[N];
        for (int i = 0; i < N; i++) {
            long l = Long.parseLong(st.nextToken());
            arr[i] = l;
        }

        long c = Long.parseLong(br.readLine());

        long cnt = 0;

        for (int i = 0; i < N; i++) {
            long cur = arr[i];
            if(cur == 0){
                continue;
            }
            long l = cur / c;
            cnt += l;
            if(cur % c != 0){
                cnt += 1;
            }
        }

        long res = c * cnt;

        bw.write(res+"");
        bw.flush();
        bw.close();
        br.close();
    }

}
