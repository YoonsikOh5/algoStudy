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
        int W = Integer.parseInt(br.readLine());

        int res = N * 10;
        if(N >= 3){
            res += 20;
        }
        if(N == 5){
            res += 50;
        }
        if(W > 1000){
            res -= 15;
        }
        res = Math.max(res, 0);

        bw.write(res+"");
        bw.flush();
        bw.close();
        br.close();
    }

}
