import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        BigInteger num = new BigInteger(br.readLine());

        while (!num.equals(new BigInteger("0"))) {

            if (num.mod(new BigInteger("42")).equals(new BigInteger("0"))) {
                bw.write("PREMIADO\n");
            } else {
                bw.write("TENTE NOVAMENTE\n");
            }

            num = new BigInteger(br.readLine());
        }
        bw.flush();
        bw.close();
        br.close();
    }


}