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
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        int X = Integer.parseInt(br.readLine());

        int min = Integer.MAX_VALUE;
        for(int p = 1; p <= a; p++){
            for(int m = 1; m <= b; m++){
                for(int c = 1; c <= d; c++){
                    int res = (p + m) * (m + c) - X;
                    int abs = Math.abs(res);
                    min = Math.min(abs, min);
                }
            }
        }

        bw.write(min+"");
        bw.flush();
        bw.close();
        br.close();
    }

}
