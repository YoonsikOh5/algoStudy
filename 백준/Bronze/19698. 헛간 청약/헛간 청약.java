import java.io.*;
import java.util.*;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        int i = (W / L) * (H / L);
        if (i <= N){
            bw.write(i+"");
        } else {
            bw.write(N+"");
        }

        bw.flush();
        bw.close();
        br.close();
    }


}