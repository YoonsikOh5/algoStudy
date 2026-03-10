import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int c = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        double[] value = new double[4];
        value[0] = (double) a / c + (double) b / d; // 0 rotation
        value[1] = (double) c / d + (double) a / b; // 1 rotation
        value[2] = (double) d / b + (double) c / a; // 2 rotations
        value[3] = (double) b / a + (double) d / c; // 3 rotations

        int answer = 0;
        double best = value[0];
        double eps = 1e-12;
        for (int i = 1; i < 4; i++) {
            if (value[i] > best + eps) {
                best = value[i];
                answer = i;
            }
        }

        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();
        br.close();
    }
}
