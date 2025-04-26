import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int curmin = Integer.MIN_VALUE;
        boolean isT = true;
        while (st.hasMoreTokens()){
            int cur = Integer.parseInt(st.nextToken());
            if(curmin > cur){
                isT = false;
                break;
            } else {
                curmin = cur;
            }
        }

        if(isT){
            bw.write("Good");
        } else {
            bw.write("Bad");
        }
        bw.flush();
        bw.close();
        br.close();
    }

}
