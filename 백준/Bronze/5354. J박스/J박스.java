import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int K = Integer.parseInt(br.readLine());
        for (int i = 0; i < K; i++) {
            int N = Integer.parseInt(br.readLine());

            for(int r = 1; r <= N; r++){
                if(r==1 || r==N){
                    for(int c = 1; c <= N; c++){
                        bw.write("#");
                    }
                } else {
                    bw.write("#");
                    for(int c = 2; c < N; c++){
                        bw.write("J");
                    }
                    bw.write("#");
                }
                bw.write("\n");
            }


            bw.write("\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }

}
