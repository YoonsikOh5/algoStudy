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

        int X = Integer.parseInt(br.readLine());

        int[] arr = new int[X];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < X; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int res = 0;

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < X; i++) {
            int cur = Integer.parseInt(st.nextToken());
            int abs = Math.abs(arr[i] - cur);
            res += abs;
        }
        res /= 2;
        bw.write(res+"");
        bw.flush();
        bw.close();
        br.close();
    }

}
