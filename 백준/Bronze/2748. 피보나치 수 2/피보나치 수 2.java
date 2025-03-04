import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        int N = Integer.parseInt(br.readLine());

        long[] arr = new long[91];
        arr[0] = 0;
        arr[1] = 1;

        for (int i = 2; i <= 90; i++) {
            arr[i] = arr[i-1] + arr[i-2];
        }

        bw.write(arr[N]+"");
        bw.flush();
        bw.close();
        br.close();
    }

}
