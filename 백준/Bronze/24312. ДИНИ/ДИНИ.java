import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] arr = new int[4];
        StringTokenizer st = new StringTokenizer(br.readLine());
        int sum = 0;
        for (int i = 0; i < 4; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            sum += arr[i];
        }
        Arrays.sort(arr);
        int abs1 = Math.abs(arr[0] - arr[1] - arr[2] + arr[3]);
        int abs2 = Math.abs(arr[0] + arr[1] + arr[2] - arr[3]);
        int res = Math.min(abs1, abs2);
        bw.write(res+"");
        bw.flush();
        bw.close();
        br.close();
    }

}
