import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            long a = Long.parseLong(st.nextToken());
            long b = Long.parseLong(st.nextToken());

            if(a == 0 && b == 0){
                break;
            }
            int cnt = 0;

            boolean isup = false;
            while (a > 0 || b > 0) {
                long la = a % 10;
                long lb = b % 10;

                a = a / 10;
                b = b / 10;

                if(isup){
                    la += 1;
                }

                if (la + lb >= 10) {
                    cnt++;
                    isup = true;
                } else {
                    isup = false;
                }
            }
            bw.write(cnt + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }

}
