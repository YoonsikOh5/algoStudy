import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int A = Integer.parseInt(br.readLine());
        int B = Integer.parseInt(br.readLine());

        int cnt = 0;
        for(int i = 1; i <= N; i++){
            if((i % A == 0) && (i % B != 0)){
            cnt++;
            } else if((i % A != 0) && (i % B == 0)){
            cnt++;
            }
        }
        bw.write(cnt+"");
        bw.flush();
        bw.close();
        br.close();
    }

}
