import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();
        int len = s.length();
        int hlf = len / 2;

        String lef = s.substring(0, hlf);
        String rig = s.substring(hlf, len);
        bw.write(lef+" "+rig);
        bw.flush();
        bw.close();
        br.close();
    }

}
