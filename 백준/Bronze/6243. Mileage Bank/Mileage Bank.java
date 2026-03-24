import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringBuilder out = new StringBuilder();
        long total = 0;
        String line;

        while ((line = br.readLine()) != null) {
            line = line.trim();

            if (line.equals("#")) {
                break;
            }

            if (line.equals("0")) {
                out.append(total).append('\n');
                total = 0;
                continue;
            }

            StringTokenizer st = new StringTokenizer(line);
            st.nextToken(); // origin city
            st.nextToken(); // destination city
            int actual = Integer.parseInt(st.nextToken());
            char classCode = st.nextToken().charAt(0);

            long earned;
            if (classCode == 'F') {
                earned = 2L * actual;
            } else if (classCode == 'B') {
                earned = actual + (actual + 1L) / 2L;
            } else { // Y
                earned = Math.max(500, actual);
            }

            total += earned;
        }

        bw.write(out.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
