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
        long a = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());

        for(long i = 0; i <= a; i++){
            long res = (2 * (a - i)) + (4 * i);
            if(res == b){
                bw.write((a-i)+" "+i);
                break;
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }

}
