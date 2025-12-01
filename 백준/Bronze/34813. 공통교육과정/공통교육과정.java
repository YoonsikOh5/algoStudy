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
        char c = s.charAt(0);
        if(c=='F'){
            bw.write("Foundation");
        } else if(c=='C'){
            bw.write("Claves");
        } else if(c=='V'){
            bw.write("Veritas");
        } else if(c=='E'){
            bw.write("Exploration");
        }
        bw.flush();
        bw.close();
        br.close();
    }

}
