import java.io.*;
import java.util.*;

public class Main {


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int k = Integer.parseInt(st.nextToken());

            bw.write("Denominations:");
            boolean isGood = true;
            int bef = Integer.parseInt(st.nextToken());
            bw.write(" "+bef);
            for (int j = 1; j < k; j++) {
                int cur = Integer.parseInt(st.nextToken());
                bw.write(" "+cur);
                if(bef*2 > cur){
                    isGood = false;
                }
                bef = cur;
            }
            bw.write("\n");
            if(isGood){
                bw.write("Good coin denominations!\n");
            } else {
                bw.write("Bad coin denominations!\n");
            }
            bw.write("\n");
        }

        bw.flush();
        bw.close();
        br.close();

    }


}
