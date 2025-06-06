import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int nm = N / 2;
        int mm = M;

        boolean findT = false;
        for(int i = 50; i >= 0; i--){

            if(i > nm){
                continue;
            }
            if(i > mm){
                continue;
            }
            int curn = N - (i * 2);
            int curm = M - i;
            if(curn + curm < K){
                continue;
            }

            bw.write(i+"");
            findT = true;
            break;
        }

        if(!findT){
            bw.write("0");
        }
        bw.flush();
        bw.close();
        br.close();
    }

}
