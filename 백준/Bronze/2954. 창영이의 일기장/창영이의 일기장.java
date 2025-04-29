import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();

        int len = s.length();

        s = s.replace("epe", "e");
        s = s.replace("apa", "a");
        s = s.replace("ipi", "i");
        s = s.replace("opo", "o");
        s = s.replace("upu", "u");


        bw.write(s+"");
        bw.flush();
        bw.close();
        br.close();
    }

}
