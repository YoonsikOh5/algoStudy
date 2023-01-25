import java.io.*;
import java.math.BigInteger;
import java.util.*;


public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String jinhoMBTI = br.readLine();

        int n = Integer.parseInt(br.readLine());

        int result = 0;

        for(int i  = 0; i < n; i++){
            String fMBTI = br.readLine();
            if(jinhoMBTI.equals(fMBTI)){
                result++;
            }
        }

        bw.write(result+"");
        bw.flush();
        bw.close();
        br.close();

    }

}
