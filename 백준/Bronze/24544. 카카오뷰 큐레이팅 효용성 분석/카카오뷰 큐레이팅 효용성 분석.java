import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];

        long sum = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            int cur = Integer.parseInt(st.nextToken());
            arr[i] = cur;
            sum += cur;
        }

        st = new StringTokenizer(br.readLine());
        long lsum = 0;
        for(int i = 0; i < N; i++){
            int cur = Integer.parseInt(st.nextToken());
            if(cur == 0){
                lsum += arr[i];
            }
        }
        bw.write(sum+"\n"+lsum);
        bw.flush();
        bw.close();
        br.close();
    }

}
