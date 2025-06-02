import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        int N = Integer.parseInt(br.readLine().trim());

        int[] arr = new int[51];

        arr[1] = 1;
        arr[2] = 2;
        int idx = 3;
        for(int k = 3; k <= 1000; k++){
            boolean isT = true;
            for(int j = 2; j < k; j++){
                if(k % j == 0){
                    isT = false;
                }
            }
            if(isT){
                arr[idx++] = k;
            }
            if(idx == 51){
                break;
            }
        }

        bw.write(N+"\n");
        for(int i = 1; i <= N; i++){
            bw.write(arr[i]+" ");
        }

        bw.flush();
        bw.close();
        br.close();
    }

}
