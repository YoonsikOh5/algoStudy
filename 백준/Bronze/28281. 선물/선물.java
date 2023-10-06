import java.io.*;
import java.util.*;

public class Main {


    public static void main(String args[]) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        long minResult = Long.MAX_VALUE;

        for(int i = 0; i < N-1; i++){
            minResult = Math.min(minResult,(arr[i]+arr[i+1]));
        }

        bw.write((minResult*X)+"");
        bw.flush();
        bw.close();
        br.close();

    }


}