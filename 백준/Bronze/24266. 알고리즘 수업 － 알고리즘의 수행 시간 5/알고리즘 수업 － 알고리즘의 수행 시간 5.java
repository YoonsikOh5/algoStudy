import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        BigInteger b = new BigInteger(br.readLine());

        BigInteger res = b.pow(3);

        bw.write(res+"\n3");

        bw.flush();
        bw.close();
        br.close();
    }

}
