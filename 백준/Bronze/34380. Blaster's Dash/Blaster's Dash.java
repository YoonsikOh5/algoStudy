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

        br.readLine();
        int cur = Integer.parseInt(br.readLine());
        br.readLine();
        cur *= 2;
        cur += 40;
        bw.write(cur+"");
        bw.flush();
        bw.close();
        br.close();
    }

}
