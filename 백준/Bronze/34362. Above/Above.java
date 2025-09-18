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

        double db = Double.parseDouble(br.readLine());
        db -= 0.3;
        String res = String.format("%.4f", db);
        bw.write(res+"");
        bw.flush();
        bw.close();
        br.close();
    }

}
