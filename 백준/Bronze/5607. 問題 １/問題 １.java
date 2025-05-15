import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        int N = Integer.parseInt(br.readLine());
        int a = 0;
        int b = 0;
        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int l = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            if(l > r){
                a += (l+r);
            } else if(l < r){
                b += (l+r);
            } else if(l==r){
                a += l;
                b += r;
            }
        }

        bw.write(a+" "+b);
        bw.flush();
        bw.close();
        br.close();
    }

}
