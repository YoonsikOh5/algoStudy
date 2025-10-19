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

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 1; i < 100; i++) {
            int cur = Integer.parseInt(st.nextToken());
        }
        int cur = Integer.parseInt(st.nextToken());
        cur %= 10;
        if(cur == 0){
            cur = 10;
        }
        bw.write(cur+"");
        bw.flush();
        bw.close();
        br.close();
    }

}
