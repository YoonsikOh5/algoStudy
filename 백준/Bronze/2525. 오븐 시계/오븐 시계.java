import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int hour = Integer.parseInt(st.nextToken());
        int minute = Integer.parseInt(st.nextToken());
        int cookMinutes = Integer.parseInt(br.readLine());

        int total = hour * 60 + minute + cookMinutes;
        int endHour = (total / 60) % 24;
        int endMinute = total % 60;

        bw.write(endHour + " " + endMinute);
        bw.flush();
        bw.close();
        br.close();
    }
}
