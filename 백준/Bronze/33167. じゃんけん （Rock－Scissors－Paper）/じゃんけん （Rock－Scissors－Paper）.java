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
        String a = br.readLine();
        String b = br.readLine();
        int ares = 0;
        int bres = 0;
        for(int i = 0; i < n; i++){
            char ac = a.charAt(i);
            char bc = b.charAt(i);

            if(ac == 'R'){
                if(bc == 'P'){
                    bres++;
                }
            } else if(ac == 'S'){
                if(bc == 'P'){
                    ares++;
                } else if(bc == 'R'){
                    bres++;
                }
            }

        }

        bw.write(ares+" "+bres);
        bw.flush();
        bw.close();
        br.close();
    }

}
