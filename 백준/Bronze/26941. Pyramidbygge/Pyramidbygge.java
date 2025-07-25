import java.io.*;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        long cur = 1;
        long sum = 0;
        int idx = 0;
        while (true){
            long l = cur * cur;
            if(sum + l > N){
                bw.write(idx+"");
                break;
            }
            sum += l;
            cur+=2;
            idx++;
        }

        bw.flush();
        bw.close();
        br.close();
    }

}
