import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        while (N != 0) {
            int[] arr = new int[50];
            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < 6; j++) {
                    int cur = Integer.parseInt(st.nextToken());
                    arr[cur] = 1;
                }
            }
            boolean isT = true;
            for (int i = 1; i <= 49; i++) {
                if (arr[i] == 0) {
                    isT = false;
                }
            }
            if (isT) {
                bw.write("Yes\n");
            } else {
                bw.write("No\n");
            }
            N = Integer.parseInt(br.readLine());
        }

        bw.flush();
        bw.close();
        br.close();
    }

}
