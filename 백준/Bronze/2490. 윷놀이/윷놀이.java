import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for (int t = 0; t < 3; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int backs = 0;

            for (int i = 0; i < 4; i++) {
                int value = Integer.parseInt(st.nextToken());
                if (value == 0) {
                    backs++;
                }
            }

            char result;
            if (backs == 1) {
                result = 'A';
            } else if (backs == 2) {
                result = 'B';
            } else if (backs == 3) {
                result = 'C';
            } else if (backs == 4) {
                result = 'D';
            } else {
                result = 'E';
            }

            bw.write(result);
            bw.newLine();
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
