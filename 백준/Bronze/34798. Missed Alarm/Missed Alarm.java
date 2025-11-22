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

        String a = br.readLine();
        String s = ":";
        String[] asp = a.split(s);
        String b = br.readLine();
        String[] bsp = b.split(s);

        String s1 = asp[0];
        int a1 = Integer.parseInt(s1);
        String s2 = asp[1];
        int a2 = Integer.parseInt(s2);
        String s3 = bsp[0];
        int b1 = Integer.parseInt(s3);
        String s4 = bsp[1];
        int b2 = Integer.parseInt(s4);

        if (a1 < b1) {
            bw.write("YES");
        } else if (a1 == b1) {
            if (a2 < b2) {
                bw.write("YES");
            } else {
                bw.write("NO");
            }
        } else {
            bw.write("NO");
        }

        bw.flush();
        bw.close();
        br.close();
    }

}
