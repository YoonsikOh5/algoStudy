import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        long N = Long.parseLong(br.readLine().trim());

        for (long i = 1; i <= N; i++) {

            if((i % 3 == 0) && (i % 5 == 0)){
                bw.write("DeadMan\n");
            } else if(i % 3 == 0){
                bw.write("Dead\n");
            } else if(i % 5 == 0){
                bw.write("Man\n");
            } else {
                bw.write(i+" ");
            }

        }

        bw.flush();
        bw.close();
        br.close();
    }

}
