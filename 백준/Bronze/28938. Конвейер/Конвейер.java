import java.io.*;
import java.util.*;

public class Main {

    public static void main(String args[]) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int sum = 0;
        for (int i = 0; i < N; i++) {
            sum += Integer.parseInt(st.nextToken());
        }

        if (sum > 0) {
            bw.write("Right");
        } else if (sum == 0) {
            bw.write("Stay");
        } else if (sum < 0) {
            bw.write("Left");
        }

        bw.flush();
        bw.close();
        br.close();

    }


}