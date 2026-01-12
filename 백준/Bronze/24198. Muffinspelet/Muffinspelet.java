import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int a = 0;
        int b = 0;

        boolean isB = true;
        while (N > 0){
            int hlf = N / 2;

            int tm = N - hlf;

            if(isB){
                b += tm;
            } else {
                a += tm;
            }
            N -= tm;
            isB = !isB;
        }
        bw.write(a+" "+b);
        bw.flush();
        bw.close();
        br.close();
    }

}
