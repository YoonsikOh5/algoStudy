import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        long w = Long.parseLong(st.nextToken());
        long h = Long.parseLong(st.nextToken());

        long yard = w * h;

        double v = (double) yard / 4840;

        double v1 = v / 5;

        long result = (long)Math.ceil(v1);

        bw.write(result + "");
        bw.flush();
        bw.close();
        br.close();
    }


}