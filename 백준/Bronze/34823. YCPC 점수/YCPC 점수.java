import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int y = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());

        int min = Math.min(y, p);
        int res = Math.min(min, c / 2);

        bw.write(res+"");
        bw.flush();
        bw.close();
        br.close();
    }

}
