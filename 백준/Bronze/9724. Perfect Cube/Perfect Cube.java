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

        int N = Integer.parseInt(br.readLine());

        for(int i = 1; i <= N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            long a = Long.parseLong(st.nextToken());
            long b = Long.parseLong(st.nextToken());

            long cnt = 0;
            for(int j = 1; j <= 1259; j++){
                int cur = j * j * j;
                if(a <= cur && cur <= b){
                    cnt++;
                }
            }
            bw.write("Case #"+i+": "+cnt+"\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

}
