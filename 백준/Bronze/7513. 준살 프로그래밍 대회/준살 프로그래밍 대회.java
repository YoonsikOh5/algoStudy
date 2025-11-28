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
        for (int tc = 1; tc <= T; tc++) {
            int m = Integer.parseInt(br.readLine());
            String[] arr = new String[m];
            for (int i = 0; i < m; i++) {
                arr[i] = br.readLine();
            }
            bw.write("Scenario #"+tc+":\n");
            int n = Integer.parseInt(br.readLine());
            for (int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int k = Integer.parseInt(st.nextToken());
                for(int j = 0; j < k; j++){
                    bw.write(arr[Integer.parseInt(st.nextToken())]+"");
                }
                bw.write("\n");
            }
            bw.write("\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

}
