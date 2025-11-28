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
        double sum = 0;
        for(int i = 0; i < k; i++){
            double cur = Double.parseDouble(br.readLine());
            sum += cur;
        }

        double min = sum + ((n-k) * -3);
        double max = sum + ((n-k) * 3);

        double minres = min / n;
        double maxres = max / n;

        bw.write(minres + " " + maxres);
        bw.flush();
        bw.close();
        br.close();
    }

}
