import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N+1];
        for (int i = 1; i <= N; i++) {
            int cur = Integer.parseInt(st.nextToken());
            arr[i] = cur;
        }
        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < M; i++){
            int cur = Integer.parseInt(st.nextToken());
            arr[cur] -= 1;
        }
        for (int i = 1; i <= N; i++) {
            if(arr[i] < 0){
                bw.write("yes\n");
            } else {
                bw.write("no\n");
            }
        }


        bw.flush();
        bw.close();
        br.close();
    }

}
