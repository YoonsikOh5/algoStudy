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

        double d = Double.parseDouble(br.readLine());
        double w = Double.parseDouble(br.readLine());
        double n = Double.parseDouble(br.readLine());

        double v = d * 3.14159;

        double v1 = w * n;
        if(v >= v1){
            bw.write("YES");
        } else {
            bw.write("NO");
        }
        bw.flush();
        bw.close();
        br.close();
    }

}
