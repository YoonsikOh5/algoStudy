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
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int bef = Integer.parseInt(br.readLine());
        int cnt = 0;
        for (int i = 1; i < n; i++) {
            int cur = Integer.parseInt(br.readLine());
            int dif = bef - cur;
            if(dif >= k){
                cnt++;
            }
            bef = cur;
        }

        bw.write(cnt+"");
        bw.flush();
        bw.close();
        br.close();
    }

}
