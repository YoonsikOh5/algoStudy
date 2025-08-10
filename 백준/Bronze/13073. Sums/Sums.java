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

        for(int i = 1; i <= T; i++){
            int N = Integer.parseInt(br.readLine());
            long s1 = ((N+1)*N)/2;
            long s2 = N*N;
            long s3 = (N+1)*N;
            bw.write(s1+" "+s2+" "+s3+"\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }

}
