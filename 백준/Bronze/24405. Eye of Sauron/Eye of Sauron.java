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
        int lcnt = 0;
        int rcnt = 0;
        boolean isE = false;
        for(int i = 0; i < len; i++){
            char cur = s.charAt(i);
            if(cur == '|' && !isE){
                lcnt++;
            } else if(cur == '|' && isE){
                rcnt++;
            } else if (cur == '(') {
                isE = true;
            }
        }
        if(lcnt==rcnt){
            bw.write("correct");
        } else {
            bw.write("fix");
        }
        bw.flush();
        bw.close();
        br.close();
    }

}
