import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] arr = new int[M];
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j < M; j++){
                int cur = Integer.parseInt(st.nextToken());
                arr[j] = Math.max(arr[j],cur);
            }
        }

        int sum = 0;
        for(int i =0 ; i < M;i++){
            sum += arr[i];
        }
        bw.write(sum+"");
        bw.flush();
        bw.close();
        br.close();
    }

}
