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
        for(int i = 0; i < N; i++){
            int cur = Integer.parseInt(br.readLine());
            long sum = 0;
            for(long j = 1; j <= cur; j++){
                sum += j*(cur-(j-1));
            }
            bw.write(sum+"\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }

}
