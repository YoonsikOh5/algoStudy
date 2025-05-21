import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int f = Integer.parseInt(st.nextToken());
        int res = 0;
        double curmin = Double.MAX_VALUE;
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            int cur = Integer.parseInt(st.nextToken());
            int sp = Integer.parseInt(st.nextToken());
            double v = (double) (f - cur) / sp;
            if(v < curmin){
                res = i+1;
                curmin = v;
            }
        }
        bw.write(res+"");
        bw.flush();
        bw.close();
        br.close();
    }

}
