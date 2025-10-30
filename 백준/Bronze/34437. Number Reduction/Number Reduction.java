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

        int cnt = 0;

        while (N > 1){
            if(N % 2 == 0){
                N /= 2;
            } else if(N % 2 == 1){
                N = 3*N+1;
            }
            cnt++;
        }

        bw.write(cnt+"");
        bw.flush();
        bw.close();
        br.close();
    }

}
