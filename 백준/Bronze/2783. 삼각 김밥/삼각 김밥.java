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

        double a = Double.parseDouble(st.nextToken());
        double b = Double.parseDouble(st.nextToken());

        double min = a / b;

        int N = Integer.parseInt(br.readLine());

        for(int i = 1; i <= N; i++){
            st = new StringTokenizer(br.readLine());
            double c = Double.parseDouble(st.nextToken());
            double d = Double.parseDouble(st.nextToken());
            min = Math.min(min, c/d);
        }

        double res = min * 1000;

        bw.write(res+"");
        bw.flush();
        bw.close();
        br.close();
    }

}
