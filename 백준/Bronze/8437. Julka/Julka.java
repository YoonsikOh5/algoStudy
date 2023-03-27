import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;
import java.util.*;

public class Main {

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BigInteger total = new BigInteger(br.readLine());
        BigInteger more = new BigInteger(br.readLine());
        if(total.mod(new BigInteger("2")).equals(new BigInteger("0"))){
            BigInteger a = total.divide(new BigInteger("2"));
            BigInteger b = total.divide(new BigInteger("2"));
            a = a.add(more.divide(new BigInteger("2")));
            b = b.subtract(more.divide(new BigInteger("2")));
            bw.write(a.toString()+"\n"+b.toString());
        } else if(total.mod(new BigInteger("2")).equals(new BigInteger("1"))){
            BigInteger a = total.divide(new BigInteger("2")).add(new BigInteger("1"));
            BigInteger b = total.divide(new BigInteger("2"));
            a = a.add(more.divide(new BigInteger("2")));
            b = b.subtract(more.divide(new BigInteger("2")));
            bw.write(a.toString()+"\n"+b.toString());
        }

        bw.flush();
        bw.close();
        br.close();
    }

}