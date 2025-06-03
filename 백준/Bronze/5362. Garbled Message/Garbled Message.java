import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String cur = "";
        while ( (cur = br.readLine()) != null && !(cur.isEmpty()) ) {
            String replace = cur.replace("iiing", "th");

            bw.write(replace+"\n");

        }

        bw.flush();
        bw.close();
        br.close();
    }

}
