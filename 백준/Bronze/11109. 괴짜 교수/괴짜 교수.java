import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int K = Integer.parseInt(br.readLine());
        for (int i = 0; i < K; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int d = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());

            int a = n * s;
            int b = d + (n * p);

            if(a < b){
                bw.write("do not parallelize");
            } else if(a > b){
                bw.write("parallelize");
            } else if(a == b){
                bw.write("does not matter");
            }

            bw.write("\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }

}
