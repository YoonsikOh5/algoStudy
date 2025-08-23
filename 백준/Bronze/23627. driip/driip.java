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

        String s = br.readLine();

        int len = s.length();
        if(len >= 5){
            String sub = s.substring(len - 5);
            if(sub.equals("driip")){
                bw.write("cute");
            } else {
                bw.write("not cute");
            }
        } else {
            bw.write("not cute");
        }


        bw.flush();
        bw.close();
        br.close();
    }

}
