import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        long n = Long.parseLong(br.readLine().trim());
        long steps = 0;

        while (n != 1) {
            if ((n & 1L) == 0L) {
                n /= 2;
            } else {
                n += 1;
            }
            steps++;
        }

        bw.write(String.valueOf(steps));
        bw.flush();
        bw.close();
        br.close();
    }
}
