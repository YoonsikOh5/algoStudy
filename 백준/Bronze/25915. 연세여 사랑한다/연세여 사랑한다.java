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
        String s = br.readLine();
        char cur = s.charAt(0);
        int i = cur - 'A';
        int i1 = i - 8;
        int abs = Math.abs(i1);
        int res = 84 + abs;
        bw.write(res+"");
        bw.flush();
        bw.close();
        br.close();
    }

}
