import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int z = Integer.parseInt(br.readLine().trim());

        for (int tc = 0; tc < z; tc++) {
            int sumR = 0;
            int sumG = 0;
            int sumB = 0;

            for (int i = 0; i < 10; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                sumR += Integer.parseInt(st.nextToken());
                sumG += Integer.parseInt(st.nextToken());
                sumB += Integer.parseInt(st.nextToken());
            }

            int avgR = (sumR + 5) / 10;
            int avgG = (sumG + 5) / 10;
            int avgB = (sumB + 5) / 10;

            bw.write(avgR + " " + avgG + " " + avgB);
            bw.newLine();
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
