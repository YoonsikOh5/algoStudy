import java.io.*;
import java.util.*;

public class Main {

    public static void main(String args[]) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int hourSum = 0;
        for (int i = 0; i < N; i++) {
            hourSum += Integer.parseInt(st.nextToken());
            if (i < N - 1) hourSum += 8;
        }

        int hour = hourSum / 24;
        int min = hourSum % 24;

        bw.write(hour + " " + min);
        bw.flush();
        bw.close();
        br.close();
    }


}