import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        long d = Long.parseLong(st.nextToken());
        long m = Long.parseLong(st.nextToken());
        long w = Long.parseLong(st.nextToken());

        st = new StringTokenizer(br.readLine());
        long i = Long.parseLong(st.nextToken());
        long j = Long.parseLong(st.nextToken()); 
        long k = Long.parseLong(st.nextToken());

        long offset = (k - 1) * m * d + (j - 1) * d + (i - 1);
        long idx = offset % w;

        char res = (char) ('a' + idx);

        bw.write(res+"");
        bw.flush();
        bw.close();
        br.close();
    }

}
