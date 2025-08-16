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

        int nmod3 = n % 3;
        int ndiv3 = n / 3;
        if(nmod3 == 1){
            if(ndiv3 > 0){
                ndiv3 -=1;
            }
            bw.write("2 "+ndiv3);
        } else if(nmod3 == 2){
            bw.write("1 "+ndiv3);
        } else if(nmod3 == 0){
            bw.write("0 "+ndiv3);
        }

        bw.flush();
        bw.close();
        br.close();
    }

}
