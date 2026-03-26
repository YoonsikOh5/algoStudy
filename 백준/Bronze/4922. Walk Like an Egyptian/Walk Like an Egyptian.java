import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringBuilder out = new StringBuilder();
        String line;

        while ((line = br.readLine()) != null) {
            line = line.trim();
            if (line.equals("0")) {
                break;
            }

            long n = Long.parseLong(line);
            long result = n * n - n + 1;

            out.append(n).append(" => ").append(result).append('\n');
        }

        bw.write(out.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
