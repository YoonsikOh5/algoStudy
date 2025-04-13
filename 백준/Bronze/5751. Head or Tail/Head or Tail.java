import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        while(N > 0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int mc = 0;
            int jc = 0;
            for(int i = 0; i < N; i++){
                int cur = Integer.parseInt(st.nextToken());
                if(cur==0){
                    mc++;
                } else if(cur==1) {
                    jc++;
                }
            }
            bw.write("Mary won "+mc+" times and John won "+jc+" times\n");
            N = Integer.parseInt(br.readLine());
        }

        bw.flush();
        bw.close();
        br.close();
    }

}
