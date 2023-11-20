import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        int[] garr = {0, 1, 3, 5};

        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int G = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());
            int remain = E - C;
            if (remain < 0) {
                bw.write("0\n");
            } else {
                int result = remain * garr[G];
                bw.write(result+"\n");
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }

}