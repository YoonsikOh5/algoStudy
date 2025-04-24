import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        int N = Integer.parseInt(br.readLine());

        for(int i = 1; i <= N; i++){
            bw.write("1");
        }
        for(int i = 1; i <= N-1; i++){
            bw.write("0");
        }
        bw.flush();
        bw.close();
        br.close();
    }

}
