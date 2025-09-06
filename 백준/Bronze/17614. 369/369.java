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
        int n = Integer.parseInt(br.readLine());
        int res = 0;
        for(int i = 1; i <= n; i++){
            int cur = i;
            while (cur > 0){
                int rem = cur % 10;
                if(rem == 3 || rem == 6 || rem == 9){
                    res++;
                }
                cur /= 10;
            }
        }

        bw.write(res+"");
        bw.flush();
        bw.close();
        br.close();
    }

}
