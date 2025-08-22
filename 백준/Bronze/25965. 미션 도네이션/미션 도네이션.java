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

        long N = Integer.parseInt(br.readLine());

        for(int i = 0; i < N; i++){
            int M = Integer.parseInt(br.readLine());
            long[] K = new long[M];
            long[] D = new long[M];
            long[] A = new long[M];
            for(int j = 0; j < M; j++){
            StringTokenizer st = new StringTokenizer(br.readLine());
                K[j] = Long.parseLong(st.nextToken());
                D[j] = Long.parseLong(st.nextToken());
                A[j] = Long.parseLong(st.nextToken());
            }
            StringTokenizer st = new StringTokenizer(br.readLine());
            long k = Long.parseLong(st.nextToken());
            long d = Long.parseLong(st.nextToken());
            long a = Long.parseLong(st.nextToken());
            long res = 0;
            for(int j = 0; j < M; j++){
                long cur = (k*K[j]) - (d*D[j]) + (a*A[j]);
                if(cur > 0){
                    res += cur;
                }
            }

            bw.write(res+"\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }

}
