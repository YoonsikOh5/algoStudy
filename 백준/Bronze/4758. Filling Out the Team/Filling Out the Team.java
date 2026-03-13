import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String line;
        while ((line = br.readLine()) != null) {
            StringTokenizer st = new StringTokenizer(line);
            double speed = Double.parseDouble(st.nextToken());
            double weight = Double.parseDouble(st.nextToken());
            double strength = Double.parseDouble(st.nextToken());

            if (speed == 0.0 && weight == 0.0 && strength == 0.0) {
                break;
            }

            StringBuilder result = new StringBuilder();

            if (speed <= 4.5 && weight >= 150 && strength >= 200) {
                result.append("Wide Receiver ");
            }
            if (speed <= 6.0 && weight >= 300 && strength >= 500) {
                result.append("Lineman ");
            }
            if (speed <= 5.0 && weight >= 200 && strength >= 300) {
                result.append("Quarterback ");
            }

            if (result.length() == 0) {
                bw.write("No positions");
            } else {
                bw.write(result.toString().trim());
            }
            bw.newLine();
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
