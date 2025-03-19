import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        long K = Long.parseLong(st.nextToken());
        long N = Long.parseLong(st.nextToken());

        if(N == 1){
            bw.write("-1");
        } else {
            long res = (K * N) / (N - 1);
            if((K*N) % (N-1) != 0){
                res++;
            }
            bw.write(res+"");
        }

        bw.flush();
        bw.close();
        br.close();
    }

}
