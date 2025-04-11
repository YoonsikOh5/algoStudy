import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        if(n == 0){
            bw.write("divide by zero");
        } else {
            br.readLine();
            bw.write("1.00");
        }
        bw.flush();
        bw.close();
        br.close();
    }

}
