import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[4];
        for (int i = 0; i < 4; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        boolean isT = true;
        int cnt = 0;
        for (int i = 0; i < 2; i++) {
            if (arr[i] != arr[3 - i]) {
                if (isT && (cnt == 0)) {
                    arr[i] = arr[3 - i];
                    cnt++;
                } else if (isT && (cnt == 1)) {
                    isT = false;
                }
            }
        }
        if (isT) {
            bw.write("JAH\n");
            for (int i = 0; i < 4; i++) {
                bw.write(arr[i] + " ");
            }
        } else {
            bw.write("EI");
        }
        bw.flush();
        bw.close();
        br.close();
    }

}
