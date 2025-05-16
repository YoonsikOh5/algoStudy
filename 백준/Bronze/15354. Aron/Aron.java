import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        int N = Integer.parseInt(br.readLine());
        int cnt = 1;
        String cur = br.readLine();
        String bef = cur;
        for(int i = 1; i < N; i++){
            cur = br.readLine();
            if(!cur.equals(bef)) cnt++;
            bef = cur;
        }
        cnt++;
        bw.write(cnt+"");
        bw.flush();
        bw.close();
        br.close();
    }

}
