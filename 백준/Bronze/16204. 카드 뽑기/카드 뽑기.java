import java.io.*;
import java.util.*;

public class Main {


    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int o = M;
        int x = N - o;
        int sum = 0;
        sum += Math.min(o,K);
        sum += Math.min(x,N-K);

        bw.write(sum+"");
        bw.flush();
        bw.close();
        br.close();
    }


}