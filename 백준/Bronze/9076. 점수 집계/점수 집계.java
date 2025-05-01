import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int K = Integer.parseInt(br.readLine());
        for (int i = 0; i < K; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int[] arr = new int[5];

            for(int j = 0; j < 5; j++){
                arr[j] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(arr);

            if(arr[4] - arr[1] >= 4){
                bw.write("KIN\n");
            } else {
                int sum = arr[1]+arr[2]+arr[3];
                bw.write(sum+"\n");
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }

}
