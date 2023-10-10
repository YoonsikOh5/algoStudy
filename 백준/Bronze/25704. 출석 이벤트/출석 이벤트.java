import java.io.*;
import java.util.*;

public class Main {


    public static void main(String args[]) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int P = Integer.parseInt(br.readLine());
        int resultMin = P;
        if (N >= 5) {
            resultMin = Math.min(resultMin, P - 500);
            if (N >= 10) {
                resultMin = Math.min(resultMin, (int) (P * 0.9));
                if (N >= 15) {
                    resultMin = Math.min(resultMin, P - 2000);
                    if (N >= 20) {
                        resultMin = Math.min(resultMin, (int) (P * 0.75));
                    }
                }
            }
        }
        if (resultMin<=0) resultMin = 0;
        bw.write(resultMin + "");
        bw.flush();
        bw.close();
        br.close();
    }


}