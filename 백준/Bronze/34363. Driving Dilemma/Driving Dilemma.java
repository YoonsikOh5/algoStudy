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

        double S = Double.parseDouble(br.readLine());
        double D = Double.parseDouble(br.readLine());
        double T = Double.parseDouble(br.readLine());

        double ss = S * 5280 / 60 / 60;

        double v = ss * T;

        if(D <= v){
            bw.write("MADE IT");
        } else {
            bw.write("FAILED TEST");
        }

        bw.flush();
        bw.close();
        br.close();
    }

}
