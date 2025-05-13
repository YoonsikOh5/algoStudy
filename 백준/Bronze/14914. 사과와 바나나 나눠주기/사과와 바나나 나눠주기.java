import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        int min = Math.min(a, b);

        for(int i = 1; i <= min; i++){
            if(a % i == 0 && b % i == 0){
                bw.write(i+" "+(a/i)+" "+(b/i)+"\n");
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }

}
