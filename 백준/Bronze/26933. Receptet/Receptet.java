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

        int T = Integer.parseInt(br.readLine());
        int res = 0;
        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int H = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());
            int a = B - H;
            if(a > 0){
                res += (a * K);
            }
        }

        bw.write(res+"");
        bw.flush();
        bw.close();
        br.close();
    }

}
