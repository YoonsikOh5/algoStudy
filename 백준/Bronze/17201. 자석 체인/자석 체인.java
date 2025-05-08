import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String str = br.readLine();
        int bef = Integer.parseInt(String.valueOf(str.charAt(0)));
        boolean isT = true;
        for(int i = 1; i < 2*N; i++){
            int cur = Integer.parseInt(String.valueOf(str.charAt(i)));
            if(cur == bef){
                isT = false;
                break;
            } else {
                bef = cur;
            }
        }

        if(isT){
            bw.write("Yes");
        } else {
            bw.write("No");
        }
        bw.flush();
        bw.close();
        br.close();
    }

}
