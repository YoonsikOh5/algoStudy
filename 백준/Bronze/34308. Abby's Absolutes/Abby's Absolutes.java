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
        int K = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        for(int i = 1; i <= K; i++){
            int cur = Integer.parseInt(st.nextToken());
            int a1 = Math.abs(cur - 1);
            int a2 = Math.abs(N - cur);
            if(a1 <= a2){
                bw.write("1 ");
            } else {
                bw.write(N+" ");
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }

}
