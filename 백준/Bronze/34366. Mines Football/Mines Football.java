import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int a = 0;
        int b = Integer.MAX_VALUE;
        int c = 0;
        int d = Integer.MAX_VALUE;


        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int S = Integer.parseInt(st.nextToken());

            int csum = 0;
            int dsum = 0;

            for(int j = 0; j < S; j++){
                int cur = Integer.parseInt(st.nextToken());
                a = Math.max(a,cur);
                b = Math.min(b,cur);
                csum += cur;
                dsum += cur;
            }
            c = Math.max(c,csum);
            d = Math.min(d,dsum);

        }

        bw.write(a+"\n"+b+"\n"+c+"\n"+d+"");
        bw.flush();
        bw.close();
        br.close();
    }

}
