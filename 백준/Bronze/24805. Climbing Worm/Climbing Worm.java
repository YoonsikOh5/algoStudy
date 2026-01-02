import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


            StringTokenizer st = new StringTokenizer(br.readLine());
            long a = Long.parseLong(st.nextToken());
            long b = Long.parseLong(st.nextToken());
            long c = Long.parseLong(st.nextToken());

            int cnt = 0;
            int cur = 0;
            while (true){
                cnt++;
                cur += a;

                if(cur >= c){
                    break;
                } else {
                    cur -= b;
                }
            }

        bw.write(cnt+"");
        bw.flush();
        bw.close();
        br.close();
    }

}
