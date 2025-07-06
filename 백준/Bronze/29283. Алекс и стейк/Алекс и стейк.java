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

        long K = Long.parseLong(br.readLine());

        long res = 0;
        for(int i = 0; i < K; i++){
            long j = i;
            res += 30*((j/5)+1);
        }

        bw.write(res+"");
        bw.flush();
        bw.close();
        br.close();
    }

}
