import java.io.*;
import java.math.BigInteger;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        BigInteger bigIntegerA = new BigInteger(st.nextToken());
        BigInteger bigIntegerB = new BigInteger(st.nextToken());
        BigInteger add = bigIntegerA.add(bigIntegerB);


        bw.write(add.toString()+"");
        bw.flush();
        bw.close();
        br.close();

    }


}
