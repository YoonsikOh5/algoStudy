import java.io.*;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();

        boolean ss = s.contains("ss");
        if(ss){
            bw.write("hiss");
        } else {
            bw.write("no hiss");
        }
        bw.flush();
        bw.close();
        br.close();
    }

}
