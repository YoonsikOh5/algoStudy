import java.io.*;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true){
            StringTokenizer st = new StringTokenizer(br.readLine());

            int[] arr = new int[6];

            boolean isEnd = true;
            for(int i = 0; i < 6; i++){
                int cur = Integer.parseInt(st.nextToken());
                arr[i] = cur;
                if(cur != 0){
                    isEnd = false;
                }
            }
            if(isEnd){
                break;
            }

            Arrays.sort(arr);

            int sum = 0;
            for(int i = 1; i <= 4; i++){
                int cur = arr[i];
                sum += cur;
            }

            if(sum % 4 == 0){
                bw.write(sum/4+"\n");
            } else {

            double mean = (double) sum / 4;

            BigDecimal res = new BigDecimal(mean);
            String s = res.stripTrailingZeros().toString();

            bw.write(s+"\n");

            }

        }



        bw.flush();
        bw.close();
        br.close();
    }

}
