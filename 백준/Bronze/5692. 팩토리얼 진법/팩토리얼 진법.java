import java.io.*;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr = {0,1,2,6,24,120};
        while (N != 0){
            int res = 0;
            int idx = 1;
            while (N > 0){
                int rem = N % 10;
                N /= 10;
                res += (rem*arr[idx]);
                idx++;
            }
            bw.write(res+"\n");
            N = Integer.parseInt(br.readLine());
        }
        bw.flush();
        bw.close();
        br.close();
    }

}
