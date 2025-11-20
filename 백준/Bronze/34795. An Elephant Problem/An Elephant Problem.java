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

        int m = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        int div = d / m;
        int rem = d % m;
        if(rem > 0){
            div += 1;
        }

        bw.write(div+"");
        bw.flush();
        bw.close();
        br.close();
    }

}
