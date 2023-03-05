import java.io.*;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        BigInteger b1 = new BigInteger(br.readLine());
        BigInteger b2 = new BigInteger(br.readLine());

        bw.write(b1.add(b2).toString()+"\n");
        bw.write(b1.subtract(b2).toString()+"\n");
        bw.write(b1.multiply(b2).toString());

        bw.flush();
        bw.close();
        br.close();
    }

}
