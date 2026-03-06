import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] crates = new int[n + 1]; 
        for (int i = 0; i < m; i++) {
            int r = Integer.parseInt(br.readLine());
            crates[r]++;
        }

        int clockwise = 0;
        for (int r = 1; r <= x - 1; r++) {
            clockwise += crates[r];
        }

        int total = 0;
        for (int r = 1; r <= n; r++) {
            total += crates[r];
        }

        int counterClockwise = total - clockwise;
        int answer = Math.min(clockwise, counterClockwise);

        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();
        br.close();
    }
}
