import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int min = 0;
        int cur = 0;
        for(int i = 0; i < N; i++){
            int cc = Integer.parseInt(br.readLine());
            cur += cc;
            min = Math.min(min, cur);
        }

        int res = Math.abs(min);
        bw.write(res+"");
        bw.flush();
        bw.close();
        br.close();
    }

}
