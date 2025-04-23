import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        int N = Integer.parseInt(br.readLine());

        for(int i = 1; i <= N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            a--;
            String cur = st.nextToken();
            int len = cur.length();
            for(int j = 0; j < len; j++){
                if(j!=a){
                    bw.write(cur.charAt(j)+"");
                }
            }
            bw.write("\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }

}
