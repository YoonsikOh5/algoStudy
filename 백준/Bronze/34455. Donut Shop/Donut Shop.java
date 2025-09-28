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

        int res = Integer.parseInt(br.readLine());
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            String cmd = br.readLine();
            int cur = Integer.parseInt(br.readLine());
            if(cmd.equals("+")){
               res += cur;
            } else if(cmd.equals("-")){
               res -= cur;
            }
        }

        bw.write(res+"");
        bw.flush();
        bw.close();
        br.close();
    }

}
