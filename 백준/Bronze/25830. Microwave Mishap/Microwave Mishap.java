import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String input = br.readLine().trim();
        String[] parts = input.split(":");
        int mm = Integer.parseInt(parts[0]);
        int ss = Integer.parseInt(parts[1]);

        int expected = mm * 60 + ss;
        int actual = mm * 3600 + ss * 60;
        int extra = actual - expected;

        int h = extra / 3600;
        int m = (extra % 3600) / 60;
        int s = extra % 60;

        bw.write(String.format("%02d:%02d:%02d", h, m, s));
        bw.flush();
        bw.close();
        br.close();
    }
}
