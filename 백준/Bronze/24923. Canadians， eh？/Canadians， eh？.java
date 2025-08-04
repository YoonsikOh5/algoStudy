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

        if(s.charAt(len-3)=='e' && s.charAt(len-2)=='h'&& s.charAt(len-1)=='?'){
            bw.write("Canadian!");
        } else {
            bw.write("Imposter!");
        }
        bw.flush();
        bw.close();
        br.close();
    }

}
