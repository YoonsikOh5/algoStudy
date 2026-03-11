import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        final String target = "joke";
        long count = 0;
        String line;

        while ((line = br.readLine()) != null) {
            int from = 0;
            while (true) {
                int idx = line.indexOf(target, from);
                if (idx == -1) {
                    break;
                }
                count++;
                from = idx + 1;
            }
        }

        bw.write(String.valueOf(count));
        bw.flush();
        bw.close();
        br.close();
    }
}
