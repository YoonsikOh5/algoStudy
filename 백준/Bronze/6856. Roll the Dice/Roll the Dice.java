import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int m = Integer.parseInt(br.readLine().trim());
        int n = Integer.parseInt(br.readLine().trim());

        int count = 0;
        for (int i = 1; i <= m; i++) {
            int j = 10 - i;
            if (j >= 1 && j <= n) {
                count++;
            }
        }

        if (count == 1) {
            bw.write("There is 1 way to get the sum 10.");
        } else {
            bw.write("There are " + count + " ways to get the sum 10.");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
