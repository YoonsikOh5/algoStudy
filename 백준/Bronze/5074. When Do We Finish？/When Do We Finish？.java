import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringBuilder out = new StringBuilder();
        String line;

        while ((line = br.readLine()) != null) {
            line = line.trim();
            if (line.equals("00:00 00:00")) {
                break;
            }

            String[] parts = line.split(" ");
            String[] start = parts[0].split(":");
            String[] duration = parts[1].split(":");

            int startMinutes = Integer.parseInt(start[0]) * 60 + Integer.parseInt(start[1]);
            int durationMinutes = Integer.parseInt(duration[0]) * 60 + Integer.parseInt(duration[1]);

            int endTotal = startMinutes + durationMinutes;
            int days = endTotal / 1440;
            int endOfDay = endTotal % 1440;

            int h = endOfDay / 60;
            int m = endOfDay % 60;

            out.append(String.format("%02d:%02d", h, m));
            if (days > 0) {
                out.append(" +").append(days);
            }
            out.append('\n');
        }

        bw.write(out.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
