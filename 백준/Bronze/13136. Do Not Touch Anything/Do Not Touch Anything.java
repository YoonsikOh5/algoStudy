import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        long r = Long.parseLong(st.nextToken());
        long c = Long.parseLong(st.nextToken());
        long n = Long.parseLong(st.nextToken());

        long cr = Double.valueOf(Math.ceil((double) r / n)).longValue();
        long cc = Double.valueOf(Math.ceil((double) c / n)).longValue();

        bw.write(cr*cc+"");

        bw.flush();
        bw.close();
        br.close();
    }

}