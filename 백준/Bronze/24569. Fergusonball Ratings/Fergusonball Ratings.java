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
            int a = Integer.parseInt(br.readLine());
            int b = Integer.parseInt(br.readLine());
            int cur = a * 5 - b * 3;
            if(cur > 40){
                res++;
            }
        }

        bw.write(res+"");
        if(res == n){
            bw.write("+");
        }
        bw.flush();
        bw.close();
        br.close();
    }

}
