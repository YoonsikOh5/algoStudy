import java.io.*;
import java.util.Locale;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringBuilder out = new StringBuilder();
        int tripNo = 1;

        String line;
        while ((line = br.readLine()) != null) {
            line = line.trim();
            if (line.isEmpty()) {
                continue;
            }

            StringTokenizer st = new StringTokenizer(line);
            double diameter = Double.parseDouble(st.nextToken());
            int rev = Integer.parseInt(st.nextToken());
            double timeSeconds = Double.parseDouble(st.nextToken());

            if (rev == 0) {
                break;
            }

            double distance = diameter * Math.PI * rev / (12.0 * 5280.0);
            double mph = distance * 3600.0 / timeSeconds;

            out.append(String.format(Locale.US, "Trip #%d: %.2f %.2f%n", tripNo, distance, mph));
            tripNo++;
        }

        bw.write(out.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
