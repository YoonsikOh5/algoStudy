import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] arr = new int[27];

        String S = br.readLine();
        int len = S.length();
        for(int i = 0; i < len; i++){
            char cur = S.charAt(i);
            int ca = cur - 'a';
            arr[ca]++;
        }

        String T = br.readLine();
        int tlen = T.length();
        for(int i = 0; i < tlen; i++){
            char cur = T.charAt(i);
            int ct = cur - 'a';
            if(arr[ct]==0){
                bw.write(cur+"");
            }
        }


        bw.flush();
        bw.close();
        br.close();
    }

}
