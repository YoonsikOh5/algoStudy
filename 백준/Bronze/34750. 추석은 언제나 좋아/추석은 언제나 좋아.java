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

        double rem = 0;

        if(N >= 1000000){
            rem = N * 0.2;
        } else if(N >= 500000){
            rem = N * 0.15;
        } else if(N >= 100000){
            rem = N * 0.1;
        } else {
            rem = N * 0.05;
        }

        int rem1 = (int) rem;
        N -= rem1;
        bw.write(rem1+" "+N);
        bw.flush();
        bw.close();
        br.close();
    }

}
