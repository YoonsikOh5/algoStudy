import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = "SciComLove";
        String s = br.readLine();
        int cnt = 0;
        for(int i = 0; i < 10; i++){
            if(str.charAt(i)!=s.charAt(i)){
                cnt++;
            }
        }
        bw.write(cnt+"");
        bw.flush();
        bw.close();
        br.close();
    }

}
