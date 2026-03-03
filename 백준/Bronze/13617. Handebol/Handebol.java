import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // players
        int m = Integer.parseInt(st.nextToken()); // matches

        int answer = 0;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            boolean scoredEveryMatch = true;

            for (int j = 0; j < m; j++) {
                int goals = Integer.parseInt(st.nextToken());
                if (goals == 0) {
                    scoredEveryMatch = false;
                }
            }

            if (scoredEveryMatch) {
                answer++;
            }
        }

        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();
        br.close();
    }
}
