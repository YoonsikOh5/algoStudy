import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int gac = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        int rank = 1;
        for(int i = 1; i < N; i++){
            int cur = Integer.parseInt(st.nextToken());
            if(cur > gac){
                rank++;
            }
        }
        bw.write(rank+"");
        bw.flush();
        bw.close();
        br.close();
    }

}
