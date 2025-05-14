import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        double init = Double.parseDouble(br.readLine());
        double bef = init;
        double cur = Double.parseDouble(br.readLine());
        while (cur != 999){
            double res = cur - bef;
            bw.write(String.format("%.2f",res)+"\n");
            bef = cur;
            cur = Double.parseDouble(br.readLine());
        }

        bw.flush();
        bw.close();
        br.close();
    }

}
