import java.io.*;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDate;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BigInteger zero = new BigInteger("0");
        for (int i = 0; i < 3; i++) {
            BigInteger cnt = new BigInteger("0");

            int N = Integer.parseInt(br.readLine());
            for (int j = 0; j < N; j++) {
                BigInteger big = new BigInteger(br.readLine());
                cnt = cnt.add(big);
            }

            int res = cnt.compareTo(zero);
            if(res > 0){
                bw.write("+\n");
            } else if(res == 0){
                bw.write("0\n");
            } else if(res < 0){
                bw.write("-\n");
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }

}
